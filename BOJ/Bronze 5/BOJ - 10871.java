import java.io.*;
import java.util.*;

class Main {
    /*
     * 수열을 순서대로 읽으며 기준값 X보다 작은 값만 선택한다.
     * 선택된 값의 기존 순서를 유지하여 StringBuilder에 저장한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value < x) sb.append(value).append(' ');
        }
        System.out.print(sb);
    }
}
