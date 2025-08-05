import java.io.*;
import java.util.*;

class Solution {
    /*
     * 암호문을 연결 리스트로 저장한다.
     * I 명령은 지정 위치에 삽입하고 D 명령은 지정 위치부터 원소를 삭제한다.
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
                String type = st.nextToken();
                int position = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                if (type.equals("I")) {
                    for (int i = 0; i < count; i++) {
                        passwords.add(position + i, Integer.parseInt(st.nextToken()));
                    }
                } else {
                    for (int i = 0; i < count; i++) {
                        passwords.remove(position);
                    }
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
