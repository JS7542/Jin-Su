import java.io.*;
import java.util.*;

class Solution {
    /*
     * 대각선별 번호 규칙을 이용해 각 숫자를 (x, y) 좌표로 변환한다.
     * 두 좌표를 더한 뒤 같은 규칙의 역변환으로 결과 번호를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int[] firstPoint = coordinate(first);
            int[] secondPoint = coordinate(second);

            int x = firstPoint[0] + secondPoint[0];
            int y = firstPoint[1] + secondPoint[1];

            output.append('#').append(tc).append(' ')
                    .append(number(x, y)).append('\n');
        }

        System.out.print(output);
    }

    private static int[] coordinate(int value) {
        int diagonal = 1;

        while (diagonal * (diagonal + 1) / 2 < value) diagonal++;

        int previousTotal = (diagonal - 1) * diagonal / 2;
        int x = value - previousTotal;
        int y = diagonal - x + 1;

        return new int[]{x, y};
    }

    private static int number(int x, int y) {
        int diagonal = x + y - 1;
        return (diagonal - 1) * diagonal / 2 + x;
    }
}
