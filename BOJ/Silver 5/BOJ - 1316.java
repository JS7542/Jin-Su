import java.io.*;

class Main {
    /*
     * 단어를 왼쪽부터 확인하며 이전 문자와 달라질 때 이미 등장한 문자인지 검사한다.
     * 모든 문자가 연속 구간 하나로만 나타나는 단어의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int tc = 0; tc < n; tc++) {
            String word = br.readLine();
            boolean[] seen = new boolean[26];
            boolean valid = true;
            char previous = 0;

            for (char ch : word.toCharArray()) {
                if (ch != previous) {
                    if (seen[ch - 'a']) {
                        valid = false;
                        break;
                    }
                    seen[ch - 'a'] = true;
                    previous = ch;
                }
            }

            if (valid) answer++;
        }

        System.out.print(answer);
    }
}
