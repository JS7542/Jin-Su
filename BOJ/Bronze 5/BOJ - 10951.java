import java.io.*;
import java.util.*;

class Main {
    /*
     * 입력이 끝날 때까지 각 줄의 두 정수를 읽어 합을 계산한다.
     * 테스트 케이스 수가 없으므로 readLine이 null이 될 때 반복을 종료한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.isBlank()) continue;
            StringTokenizer st = new StringTokenizer(line);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
        }
        System.out.print(sb);
    }
}
