import java.io.*;
import java.util.*;

class Main {
    /*
     * 양수는 큰 값끼리, 음수는 작은 값끼리 묶어 곱한다.
     * 1은 곱하지 않고 더하며, 남는 음수는 0이 있으면 상쇄한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ones = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > 1) positives.add(value);
            else if (value == 1) ones++;
            else if (value == 0) hasZero = true;
            else negatives.add(value);
        }

        positives.sort(Collections.reverseOrder());
        Collections.sort(negatives);

        int answer = ones;

        for (int i = 0; i + 1 < positives.size(); i += 2) {
            answer += positives.get(i) * positives.get(i + 1);
        }

        if (positives.size() % 2 == 1) {
            answer += positives.get(positives.size() - 1);
        }

        for (int i = 0; i + 1 < negatives.size(); i += 2) {
            answer += negatives.get(i) * negatives.get(i + 1);
        }

        if (negatives.size() % 2 == 1 && !hasZero) {
            answer += negatives.get(negatives.size() - 1);
        }

        System.out.print(answer);
    }
}
