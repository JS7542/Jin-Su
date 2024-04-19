import java.io.*;
import java.util.*;

class Main {
    /*
     * 테스트 케이스마다 두 정수를 입력받아 합을 계산한다.
     * 각 결과를 StringBuilder에 저장한 뒤 한 번에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
        }
        System.out.print(sb);
    }
}
