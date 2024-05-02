import java.io.*;
import java.util.*;

class Main {
    /*
     * 알파벳별 첫 등장 위치를 -1로 초기화한다.
     * 문자열을 왼쪽부터 보며 아직 기록되지 않은 문자의 위치만 저장한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int[] first = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';
            if (first[index] == -1) first[index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : first) sb.append(value).append(' ');
        System.out.print(sb);
    }
}
