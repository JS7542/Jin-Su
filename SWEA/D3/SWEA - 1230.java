import java.io.*;
import java.util.*;

class Solution {
    /*
     * I, D, A 세 명령을 연결 리스트에 그대로 적용한다.
     * 삽입·삭제 위치와 개수를 읽어 암호문을 수정한 뒤 앞의 열 개를 출력한다.
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

                if (type.equals("I")) {
                    int position = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());

                    for (int i = 0; i < count; i++) {
                        passwords.add(position + i, Integer.parseInt(st.nextToken()));
                    }
                } else if (type.equals("D")) {
                    int position = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());

                    for (int i = 0; i < count; i++) {
                        passwords.remove(position);
                    }
                } else {
                    int count = Integer.parseInt(st.nextToken());

                    for (int i = 0; i < count; i++) {
                        passwords.add(Integer.parseInt(st.nextToken()));
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
