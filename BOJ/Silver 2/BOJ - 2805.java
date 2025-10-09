import java.io.*;
import java.util.*;

class Main {
    /*
     * 절단기 높이를 이분 탐색한다.
     * 현재 높이에서 얻는 나무 길이가 M 이상이면 더 높은 절단 높이를 시도한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long needed = Long.parseLong(st.nextToken());

        int[] trees = new int[n];
        int right = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        int left = 0;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long wood = 0;

            for (int tree : trees) {
                if (tree > mid) wood += tree - mid;
            }

            if (wood >= needed) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}
