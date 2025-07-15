import java.io.*;
import java.util.*;

class Solution {
    /*
     * 문자열을 한 칸씩 회전하며 각 변 길이만큼 잘라 만든 16진수를 집합에 저장한다.
     * 서로 다른 값을 내림차순으로 정렬해 K번째 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int rank = Integer.parseInt(st.nextToken());
            int side = length / 4;

            String value = br.readLine();
            Set<Integer> passwords = new HashSet<>();

            for (int rotation = 0; rotation < side; rotation++) {
                String rotated = value.substring(length - rotation)
                        + value.substring(0, length - rotation);

                for (int start = 0; start < length; start += side) {
                    passwords.add(Integer.parseInt(
                            rotated.substring(start, start + side),
                            16
                    ));
                }
            }

            List<Integer> sorted = new ArrayList<>(passwords);
            sorted.sort(Collections.reverseOrder());

            output.append('#').append(tc).append(' ')
                    .append(sorted.get(rank - 1)).append('\n');
        }

        System.out.print(output);
    }
}
