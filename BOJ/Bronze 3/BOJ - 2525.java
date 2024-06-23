import java.io.*;
import java.util.*;

class Main {
    /*
     * 현재 시각과 조리 시간을 모두 분으로 환산해 더한다.
     * 하루를 넘는 경우 1440으로 나눈 나머지를 시와 분으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cooking = Integer.parseInt(br.readLine().trim());

        int total = (hour * 60 + minute + cooking) % (24 * 60);
        System.out.print((total / 60) + " " + (total % 60));
    }
}
