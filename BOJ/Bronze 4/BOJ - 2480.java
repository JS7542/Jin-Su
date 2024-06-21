import java.io.*;
import java.util.*;

class Main {
    /*
     * 세 주사위의 같은 눈 개수에 따라 상금을 계산한다.
     * 모두 다르면 세 값 중 최댓값을 찾아 상금 공식에 적용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int reward;
        if (a == b && b == c) reward = 10000 + a * 1000;
        else if (a == b || a == c) reward = 1000 + a * 100;
        else if (b == c) reward = 1000 + b * 100;
        else reward = Math.max(a, Math.max(b, c)) * 100;

        System.out.print(reward);
    }
}
