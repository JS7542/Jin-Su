import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 과목에서 수강 정원 안에 들기 위해 필요한 최소 마일리지를 계산한다.
     * 필요한 마일리지들을 오름차순으로 정렬해 가진 마일리지로 최대 과목을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int courses = Integer.parseInt(st.nextToken());
        int mileage = Integer.parseInt(st.nextToken());

        int[] needed = new int[courses];

        for (int course = 0; course < courses; course++) {
            st = new StringTokenizer(br.readLine());
            int applicants = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] bids = new int[applicants];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < applicants; i++) {
                bids[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(bids);

            if (applicants < limit) {
                needed[course] = 1;
            } else {
                needed[course] = bids[applicants - limit];
            }
        }

        Arrays.sort(needed);

        int answer = 0;

        for (int value : needed) {
            if (mileage < value) break;

            mileage -= value;
            answer++;
        }

        System.out.print(answer);
    }
}
