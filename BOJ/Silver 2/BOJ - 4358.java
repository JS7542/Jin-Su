import java.io.*;
import java.util.*;

class Main {
    /*
     * 나무 이름별 등장 횟수를 사전순 TreeMap에 저장한다.
     * 전체 나무 수로 나누어 각 종의 비율을 소수점 넷째 자리까지 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> count = new TreeMap<>();
        int total = 0;
        String tree;

        while ((tree = br.readLine()) != null) {
            count.put(tree, count.getOrDefault(tree, 0) + 1);
            total++;
        }

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            double percentage = entry.getValue() * 100.0 / total;

            output.append(entry.getKey()).append(' ')
                    .append(String.format(Locale.US, "%.4f", percentage))
                    .append('\n');
        }

        System.out.print(output);
    }
}
