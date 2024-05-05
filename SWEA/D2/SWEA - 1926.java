import java.io.*;

class Solution {
    /*
     * 1부터 N까지 숫자를 문자열로 바꾸고 3, 6, 9의 개수를 센다.
     * 해당 숫자가 있으면 개수만큼 '-'를, 없으면 원래 숫자를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            int clap = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9') clap++;
            }

            if (clap == 0) sb.append(i);
            else sb.append("-".repeat(clap));
            if (i < N) sb.append(' ');
        }

        System.out.print(sb);
    }
}
