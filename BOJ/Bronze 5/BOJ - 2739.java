import java.io.*;

class Main {
    /*
     * 입력받은 수 N에 대해 1부터 9까지 곱한 구구단을 만든다.
     * 출력값을 StringBuilder에 모아 한 번에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(n).append(" * ").append(i).append(" = ").append(n * i).append('\n');
        }
        System.out.print(sb);
    }
}
