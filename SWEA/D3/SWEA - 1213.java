import java.io.*;

class Solution {
    /*
     * 본문에서 검색 문자열이 시작하는 모든 위치를 확인한다.
     * startsWith로 일치하는 위치의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            String pattern = br.readLine();
            String text = br.readLine();
            int answer = 0;

            for (int start = 0; start <= text.length() - pattern.length(); start++) {
                if (text.startsWith(pattern, start)) answer++;
            }

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }
}
