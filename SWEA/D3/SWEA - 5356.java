import java.io.*;

class Solution {
    /*
     * 다섯 문자열의 열을 왼쪽부터 순회한다.
     * 해당 열이 존재하는 문자열의 문자만 위에서 아래 순서로 이어 붙인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            String[] words = new String[5];
            int maximumLength = 0;

            for (int row = 0; row < 5; row++) {
                words[row] = br.readLine();
                maximumLength = Math.max(maximumLength, words[row].length());
            }

            StringBuilder vertical = new StringBuilder();

            for (int col = 0; col < maximumLength; col++) {
                for (String word : words) {
                    if (col < word.length()) vertical.append(word.charAt(col));
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(vertical).append('\n');
        }

        System.out.print(output);
    }
}
