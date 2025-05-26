import java.io.*;
import java.util.*;

class Main {
    /*
     * 책 제목별 판매량을 사전순 TreeMap에 센다.
     * 가장 많이 팔린 제목을 찾고 판매량이 같으면 사전순으로 앞선 제목을 유지한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> sales = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            sales.put(title, sales.getOrDefault(title, 0) + 1);
        }

        String answer = "";
        int maximum = 0;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maximum) {
                maximum = entry.getValue();
                answer = entry.getKey();
            }
        }

        System.out.print(answer);
    }
}
