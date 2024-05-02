import java.io.*;
import java.util.*;

class Main {
    /*
     * N개의 정수를 배열에 저장하고 Arrays.sort로 오름차순 정렬한다.
     * 정렬된 값을 한 줄에 하나씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(br.readLine());
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) sb.append(number).append('\n');
        System.out.print(sb);
    }
}
