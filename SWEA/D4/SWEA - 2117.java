import java.io.*;
import java.util.*;

class Solution {
    /*
     * 모든 칸을 서비스 중심으로 두고 서비스 영역 크기 K를 증가시킨다.
     * 맨해튼 거리 K 미만의 집 수익이 운영 비용 이상인 경우 집 수의 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int income = Integer.parseInt(st.nextToken());

            List<int[]> houses = new ArrayList<>();

            for (int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        houses.add(new int[]{row, col});
                    }
                }
            }

            int answer = 0;

            for (int centerRow = 0; centerRow < size; centerRow++) {
                for (int centerCol = 0; centerCol < size; centerCol++) {
                    for (int range = 1; range <= size * 2; range++) {
                        int count = 0;

                        for (int[] house : houses) {
                            int distance = Math.abs(centerRow - house[0])
                                    + Math.abs(centerCol - house[1]);

                            if (distance < range) count++;
                        }

                        int cost = range * range
                                + (range - 1) * (range - 1);

                        if (count * income >= cost) {
                            answer = Math.max(answer, count);
                        }
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
