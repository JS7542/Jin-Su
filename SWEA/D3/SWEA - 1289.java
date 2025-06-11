import java.io.*;

class Solution {
    /*
     * 초기 메모리는 모두 0이므로 목표 문자열을 왼쪽부터 비교한다.
     * 현재 상태와 다른 비트를 만나면 뒤쪽을 한 번 뒤집는 것으로 보고 상태와 횟수를 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            String target = br.readLine();
            char current = '0';
            int changes = 0;

            for (char bit : target.toCharArray()) {
                if (bit != current) {
                    current = bit;
                    changes++;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(changes).append('\n');
        }

        System.out.print(output);
    }
}
