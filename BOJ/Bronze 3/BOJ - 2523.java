import java.io.*;

class Main {
    /*
     * 별의 개수를 1부터 N까지 늘린 뒤 다시 1까지 줄인다.
     * 왼쪽 정렬된 별 문자열을 각 줄에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int stars = 1; stars <= n; stars++) {
            sb.append("*".repeat(stars)).append('\n');
        }

        for (int stars = n - 1; stars >= 1; stars--) {
            sb.append("*".repeat(stars)).append('\n');
        }

        System.out.print(sb);
    }
}
