import java.io.*;
import java.util.*;

class Solution {
    static class Customer {
        int number;
        int arrival;
        int receptionDesk;
        int receptionEnd;
        int repairDesk;
        int finish;
    }

    /*
     * 도착 고객을 접수 창구 번호 순, 접수 완료 고객을 완료 시각·창구 번호 순으로 배정한다.
     * 지정된 접수·정비 창구를 모두 이용한 고객 번호의 합을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int receptionCount = Integer.parseInt(st.nextToken());
            int repairCount = Integer.parseInt(st.nextToken());
            int customerCount = Integer.parseInt(st.nextToken());
            int targetReception = Integer.parseInt(st.nextToken()) - 1;
            int targetRepair = Integer.parseInt(st.nextToken()) - 1;

            int[] receptionTime = new int[receptionCount];
            int[] repairTime = new int[repairCount];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < receptionCount; i++) {
                receptionTime[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < repairCount; i++) {
                repairTime[i] = Integer.parseInt(st.nextToken());
            }

            Customer[] customers = new Customer[customerCount];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < customerCount; i++) {
                Customer customer = new Customer();
                customer.number = i + 1;
                customer.arrival = Integer.parseInt(st.nextToken());
                customer.receptionDesk = -1;
                customer.repairDesk = -1;
                customers[i] = customer;
            }

            Customer[] receptionDesk = new Customer[receptionCount];
            Customer[] repairDesk = new Customer[repairCount];

            Queue<Customer> receptionWaiting = new ArrayDeque<>();
            PriorityQueue<Customer> repairWaiting = new PriorityQueue<>(
                    (first, second) -> {
                        int compare = Integer.compare(
                                first.receptionEnd,
                                second.receptionEnd
                        );

                        return compare != 0
                                ? compare
                                : Integer.compare(
                                        first.receptionDesk,
                                        second.receptionDesk
                                );
                    }
            );

            int nextArrival = 0;
            int completed = 0;
            int time = 0;

            while (completed < customerCount) {
                while (nextArrival < customerCount
                        && customers[nextArrival].arrival <= time) {
                    receptionWaiting.offer(customers[nextArrival++]);
                }

                for (int desk = 0; desk < receptionCount; desk++) {
                    Customer customer = receptionDesk[desk];

                    if (customer != null && customer.receptionEnd == time) {
                        repairWaiting.offer(customer);
                        receptionDesk[desk] = null;
                    }
                }

                for (int desk = 0; desk < repairCount; desk++) {
                    Customer customer = repairDesk[desk];

                    if (customer != null && customer.finish == time) {
                        repairDesk[desk] = null;
                        completed++;
                    }
                }

                for (int desk = 0; desk < receptionCount; desk++) {
                    if (receptionDesk[desk] != null || receptionWaiting.isEmpty()) {
                        continue;
                    }

                    Customer customer = receptionWaiting.poll();
                    customer.receptionDesk = desk;
                    customer.receptionEnd = time + receptionTime[desk];
                    receptionDesk[desk] = customer;
                }

                for (int desk = 0; desk < repairCount; desk++) {
                    if (repairDesk[desk] != null || repairWaiting.isEmpty()) {
                        continue;
                    }

                    Customer customer = repairWaiting.poll();
                    customer.repairDesk = desk;
                    customer.finish = time + repairTime[desk];
                    repairDesk[desk] = customer;
                }

                time++;
            }

            int answer = 0;

            for (Customer customer : customers) {
                if (customer.receptionDesk == targetReception
                        && customer.repairDesk == targetRepair) {
                    answer += customer.number;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer == 0 ? -1 : answer).append('\n');
        }

        System.out.print(output);
    }
}
