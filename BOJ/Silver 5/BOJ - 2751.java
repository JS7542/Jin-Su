import java.io.*;
import java.util.*;

class Main {
    /*
     * 많은 정수를 배열에 저장하고 효율적인 기본 정렬을 사용한다.
     * 출력 호출을 줄이기 위해 모든 값을 StringBuilder에 저장한다.
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
