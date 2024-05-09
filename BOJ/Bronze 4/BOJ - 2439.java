import java.io.*;

class Main {
    /*
     * 별을 오른쪽에 맞추기 위해 앞쪽에 N-i개의 공백을 배치한다.
     * 각 줄마다 공백과 별을 조합해 출력 문자열을 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n - i)).append("*".repeat(i)).append('\n');
        }
        System.out.print(sb);
    }
}
