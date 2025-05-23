import java.io.*;

class Main {
    /*
     * 알파벳 빈도에서 홀수 개 문자가 두 개 이상이면 팰린드롬을 만들 수 없다.
     * 절반 문자열을 사전순으로 만들고 가운데 문자와 뒤집은 절반을 이어 붙인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int[] count = new int[26];

        for (char ch : name.toCharArray()) count[ch - 'A']++;

        int oddCount = 0;
        char middle = 0;
        StringBuilder half = new StringBuilder();

        for (int alphabet = 0; alphabet < 26; alphabet++) {
            if (count[alphabet] % 2 == 1) {
                oddCount++;
                middle = (char) ('A' + alphabet);
            }

            half.append(String.valueOf((char) ('A' + alphabet))
                    .repeat(count[alphabet] / 2));
        }

        if (oddCount > 1) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }

        StringBuilder answer = new StringBuilder(half);

        if (middle != 0) answer.append(middle);

        answer.append(half.reverse());
        System.out.print(answer);
    }
}
