import java.io.*;
import java.util.*;

class Solution {
    /*
     * 암호문을 연결 리스트로 저장한다.
     * I 명령마다 지정 위치에 주어진 숫자들을 순서대로 삽입한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> passwords = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                passwords.add(Integer.parseInt(st.nextToken()));
            }

            int commands = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int command = 0; command < commands; command++) {
                st.nextToken();
                int position = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                for (int i = 0; i < count; i++) {
                    passwords.add(position + i, Integer.parseInt(st.nextToken()));
                }
            }

            output.append('#').append(tc).append(' ');

            for (int i = 0; i < 10; i++) {
                output.append(passwords.get(i)).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
