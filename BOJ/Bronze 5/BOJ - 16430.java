import java.io.*;
import java.util.*;

class Main {
    /*
     * 전체 치즈 B조각에서 제리가 먹은 A조각을 뺀다.
     * 남은 치즈 비율을 B-A와 B의 분수로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int eaten = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        System.out.print((total - eaten) + " " + total);
    }
}
