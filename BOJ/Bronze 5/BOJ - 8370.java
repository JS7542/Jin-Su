import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 비행기 구역의 행 수와 행당 좌석 수를 각각 곱한다.
     * 두 구역 좌석 수의 합을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstRows = Integer.parseInt(st.nextToken());
        int firstSeats = Integer.parseInt(st.nextToken());
        int secondRows = Integer.parseInt(st.nextToken());
        int secondSeats = Integer.parseInt(st.nextToken());

        System.out.print(firstRows * firstSeats + secondRows * secondSeats);
    }
}
