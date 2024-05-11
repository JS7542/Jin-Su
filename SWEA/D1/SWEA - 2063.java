import java.io.*;
import java.util.*;

class Solution {
    /*
     * N개의 정수를 배열에 저장하고 오름차순으로 정렬한다.
     * N은 홀수이므로 가운데 인덱스 N/2의 값을 중앙값으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        System.out.print(numbers[n / 2]);
    }
}
