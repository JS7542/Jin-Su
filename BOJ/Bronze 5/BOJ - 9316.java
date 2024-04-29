import java.io.*;

class Main {
    /*
     * 입력받은 테스트 케이스 수만큼 번호를 1부터 증가시킨다.
     * Hello World, Judge i! 형식의 문장을 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("Hello World, Judge ").append(i).append("!").append('\n');
        }

        System.out.print(sb);
    }
}
