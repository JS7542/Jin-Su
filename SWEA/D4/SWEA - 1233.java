import java.io.*;
import java.util.*;

class Solution {
    /*
     * 자식이 있는 노드는 연산자여야 하고, 자식이 없는 노드는 숫자여야 한다.
     * 입력 노드 형식이 이 규칙을 모두 만족하는지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String value = st.nextToken();
                boolean hasChildren = st.hasMoreTokens();

                if (hasChildren) {
                    st.nextToken();
                    st.nextToken();

                    if (!"+-*/".contains(value)) valid = false;
                } else if (!Character.isDigit(value.charAt(0))) {
                    valid = false;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(valid ? 1 : 0).append('\n');
        }

        System.out.print(output);
    }
}
