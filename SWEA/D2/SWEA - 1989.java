import java.io.*;

class Solution {
    /*
     * 문자열의 양 끝 문자를 안쪽으로 이동하며 서로 같은지 비교한다.
     * 모든 쌍이 같으면 회문이므로 1, 다르면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine().trim();
            boolean palindrome = true;

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    palindrome = false;
                    break;
                }
            }

            sb.append('#').append(tc).append(' ').append(palindrome ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }
}
