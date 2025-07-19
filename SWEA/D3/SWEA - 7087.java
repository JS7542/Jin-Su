import java.io.*;

class Solution {
    /*
     * 문제 제목 첫 글자의 등장 여부를 알파벳별로 표시한다.
     * A부터 연속으로 존재하는 글자 수를 세어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int count = Integer.parseInt(br.readLine());
            boolean[] exists = new boolean[26];

            for (int i = 0; i < count; i++) {
                String title = br.readLine();
                exists[title.charAt(0) - 'A'] = true;
            }

            int answer = 0;

            while (answer < 26 && exists[answer]) answer++;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
