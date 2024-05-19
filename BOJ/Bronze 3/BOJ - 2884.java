import java.io.*;
import java.util.*;

class Main {
    /*
     * 입력 시각을 분 단위로 바꾼 뒤 45분을 뺀다.
     * 음수가 되면 하루의 분 수를 더하고 다시 시와 분으로 변환한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int total = hour * 60 + minute - 45;
        if (total < 0) total += 24 * 60;

        System.out.print((total / 60) + " " + (total % 60));
    }
}
