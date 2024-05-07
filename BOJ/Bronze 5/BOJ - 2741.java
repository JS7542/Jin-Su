import java.io.*;

class Main {
    /*
     * 1부터 N까지의 정수를 오름차순으로 출력한다.
     * 반복 출력 비용을 줄이기 위해 StringBuilder에 저장한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) sb.append(i).append('\n');
        System.out.print(sb);
    }
}
