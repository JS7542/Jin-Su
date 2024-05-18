import java.io.*;

class Main {
    /*
     * 소문자 문자열을 순회하며 알파벳별 등장 횟수를 센다.
     * a부터 z까지의 빈도수를 공백으로 구분해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];

        for (char ch : br.readLine().toCharArray()) count[ch - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int value : count) sb.append(value).append(' ');

        System.out.print(sb);
    }
}
