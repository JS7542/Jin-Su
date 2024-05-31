import java.io.*;
import java.util.*;

class Main {
    /*
     * N개의 정수를 읽어 배열에 저장한 뒤 찾을 값 v를 입력받는다.
     * 배열에서 v와 같은 원소의 개수를 세어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(br.readLine());

        int count = 0;
        for (int number : numbers) if (number == v) count++;
        System.out.print(count);
    }
}
