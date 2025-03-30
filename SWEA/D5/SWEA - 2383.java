import java.io.*;
import java.util.*;

class Solution {
    static List<int[]> people;
    static int[][] stairs;
    static int answer;

    /*
     * 각 사람을 두 계단 중 하나에 배정하는 모든 경우를 시도한다.
     * 계단별 도착 시간을 정렬하고 동시에 최대 세 명이라는 조건으로 완료 시간을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int size = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            stairs = new int[2][3];
            int stairIndex = 0;

            for (int row = 0; row < size; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    int value = Integer.parseInt(st.nextToken());

                    if (value == 1) {
                        people.add(new int[]{row, col});
                    } else if (value > 1) {
                        stairs[stairIndex++] = new int[]{row, col, value};
                    }
                }
            }

            answer = Integer.MAX_VALUE;
            assign(0, new int[people.size()]);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void assign(int index, int[] selectedStair) {
        if (index == people.size()) {
            int first = stairTime(0, selectedStair);
            int second = stairTime(1, selectedStair);
            answer = Math.min(answer, Math.max(first, second));
            return;
        }

        selectedStair[index] = 0;
        assign(index + 1, selectedStair);

        selectedStair[index] = 1;
        assign(index + 1, selectedStair);
    }

    static int stairTime(int stairIndex, int[] selectedStair) {
        List<Integer> arrivals = new ArrayList<>();
        int[] stair = stairs[stairIndex];

        for (int personIndex = 0; personIndex < people.size(); personIndex++) {
            if (selectedStair[personIndex] != stairIndex) continue;

            int[] person = people.get(personIndex);
            int arrival = Math.abs(person[0] - stair[0])
                    + Math.abs(person[1] - stair[1]) + 1;
            arrivals.add(arrival);
        }

        Collections.sort(arrivals);
        int[] finish = new int[arrivals.size()];

        for (int index = 0; index < arrivals.size(); index++) {
            int start = arrivals.get(index);

            if (index >= 3) start = Math.max(start, finish[index - 3]);

            finish[index] = start + stair[2];
        }

        return finish.length == 0 ? 0 : finish[finish.length - 1];
    }
}
