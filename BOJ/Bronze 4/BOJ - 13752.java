import java.io.*;

class Main {
    /*
     * 각 테스트 케이스의 막대 길이를 입력받는다.
     * 길이만큼 등호 문자를 반복해 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tests-- > 0) {
            int length = Integer.parseInt(br.readLine());
            sb.append("=".repeat(length)).append('\n');
        }

        System.out.print(sb);
    }
}
