import java.io.*;
import java.util.*;

class Main {
    /*
     * 레고 길이를 정렬하고 양 끝 포인터의 합을 확인한다.
     * 정확히 구멍 길이가 되는 쌍을 찾으면 가장 차이가 큰 쌍이므로 즉시 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.isBlank()) continue;

            long hole = Long.parseLong(line) * 10_000_000L;
            int pieces = Integer.parseInt(br.readLine());

            long[] lengths = new long[pieces];

            for (int i = 0; i < pieces; i++) {
                lengths[i] = Long.parseLong(br.readLine());
            }

            Arrays.sort(lengths);

            int left = 0;
            int right = pieces - 1;
            boolean found = false;

            while (left < right) {
                long sum = lengths[left] + lengths[right];

                if (sum == hole) {
                    output.append("yes ")
                            .append(lengths[left]).append(' ')
                            .append(lengths[right]).append('\n');
                    found = true;
                    break;
                }

                if (sum < hole) left++;
                else right--;
            }

            if (!found) output.append("danger\n");
        }

        System.out.print(output);
    }
}
