import java.io.*;
import java.util.*;

class Main {
    /*
     * 중복을 제거하면서 길이 오름차순, 길이가 같으면 사전순으로 정렬한다.
     * 조건을 가진 TreeSet에 단어를 저장하고 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> words = new TreeSet<>((a, b) -> {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        for (int i = 0; i < n; i++) words.add(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (String word : words) sb.append(word).append('\n');
        System.out.print(sb);
    }
}
