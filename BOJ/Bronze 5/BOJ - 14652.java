import java.io.*;
import java.util.*;

class Main {
    /*
     * 좌석 번호 K를 한 행의 좌석 수 M으로 나눈다.
     * 몫은 행 번호, 나머지는 열 번호가 된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int seat = Integer.parseInt(st.nextToken());

        System.out.print(seat / columns + " " + seat % columns);
    }
}
