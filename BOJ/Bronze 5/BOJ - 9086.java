import java.io.*;

class Main {
    /*
     * 각 문자열의 첫 문자와 마지막 문자를 선택한다.
     * 테스트 케이스별 결과를 StringBuilder에 누적해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String text = br.readLine();
            sb.append(text.charAt(0)).append(text.charAt(text.length() - 1)).append('\n');
        }

        System.out.print(sb);
    }
}
