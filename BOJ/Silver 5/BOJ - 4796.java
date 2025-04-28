import java.io.*;
import java.util.*;

class Main {
    /*
     * 완전한 P일 주기마다 L일을 사용할 수 있다.
     * 남은 날짜에서는 L일과 남은 날짜 중 작은 값만 추가로 사용할 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int test = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int available = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());
            int vacation = Integer.parseInt(st.nextToken());

            if (available == 0 && period == 0 && vacation == 0) break;

            int answer = vacation / period * available
                    + Math.min(available, vacation % period);

            output.append("Case ").append(test++)
                    .append(": ").append(answer).append('\n');
        }

        System.out.print(output);
    }
}
