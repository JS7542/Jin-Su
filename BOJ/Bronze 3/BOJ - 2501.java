import java.io.*;
import java.util.*;

class Main {
    /*
     * 1부터 N까지 순회하며 N을 나누어떨어지게 하는 수를 센다.
     * K번째 약수를 찾으면 출력하고 존재하지 않으면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && ++count == k) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}
