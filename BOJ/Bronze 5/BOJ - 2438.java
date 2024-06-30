import java.io.*;

class Main {
    /*
     * 첫 줄부터 N번째 줄까지 별의 개수를 하나씩 증가시킨다.
     * 각 줄의 별을 StringBuilder에 이어 붙여 한 번에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i)).append('\n');
        }
        System.out.print(sb);
    }
}
