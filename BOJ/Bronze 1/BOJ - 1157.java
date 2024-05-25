import java.io.*;

class Main {
    /*
     * 문자열을 대문자로 통일하고 각 알파벳의 등장 횟수를 센다.
     * 최대 빈도가 여러 개면 ?, 하나뿐이면 해당 알파벳을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().toUpperCase();
        int[] count = new int[26];

        for (char ch : text.toCharArray()) count[ch - 'A']++;

        int max = -1;
        char answer = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) ('A' + i);
            } else if (count[i] == max) {
                answer = '?';
            }
        }

        System.out.print(answer);
    }
}
