import java.io.*;

class Main {
    /*
     * N부터 1까지의 정수를 내림차순으로 출력한다.
     * 모든 값을 StringBuilder에 모아 출력 호출을 한 번만 수행한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 1; i--) sb.append(i).append('\n');
        System.out.print(sb);
    }
}
