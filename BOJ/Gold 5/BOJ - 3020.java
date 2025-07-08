import java.io.*;
import java.util.*;

class Main {
    /*
     * 석순과 종유석 높이 빈도를 각각 누적해 특정 높이를 막는 장애물 수를 계산한다.
     * 모든 비행 높이에서 부딪히는 장애물 수의 최솟값과 그 높이 개수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int obstacles = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] bottom = new int[height + 2];
        int[] top = new int[height + 2];

        for (int index = 0; index < obstacles; index++) {
            int size = Integer.parseInt(br.readLine());

            if (index % 2 == 0) bottom[size]++;
            else top[size]++;
        }

        for (int size = height - 1; size >= 1; size--) {
            bottom[size] += bottom[size + 1];
            top[size] += top[size + 1];
        }

        int minimum = Integer.MAX_VALUE;
        int count = 0;

        for (int level = 1; level <= height; level++) {
            int collisions = bottom[level] + top[height - level + 1];

            if (collisions < minimum) {
                minimum = collisions;
                count = 1;
            } else if (collisions == minimum) {
                count++;
            }
        }

        System.out.print(minimum + " " + count);
    }
}
