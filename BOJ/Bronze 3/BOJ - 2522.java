import java.io.*;

class Main {
    /*
     * 별의 개수를 1부터 N까지 늘린 뒤 다시 1까지 줄인다.
     * 각 줄 앞에 N-별 개수만큼 공백을 넣어 오른쪽에 맞춘다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int stars = 1; stars <= n; stars++) {
            sb.append(" ".repeat(n - stars))
              .append("*".repeat(stars))
              .append('\n');
        }

        for (int stars = n - 1; stars >= 1; stars--) {
            sb.append(" ".repeat(n - stars))
              .append("*".repeat(stars))
              .append('\n');
        }

        System.out.print(sb);
    }
}
