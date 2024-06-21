import java.io.*;
import java.util.*;

class Main {
    /*
     * 매분 입구로 들어온 차량을 더하고 출구로 나간 차량을 뺀다.
     * 차량 수가 음수가 되면 0을, 아니면 관측된 최대 차량 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int periods = Integer.parseInt(br.readLine());
        int cars = Integer.parseInt(br.readLine());
        int max = cars;

        for (int i = 0; i < periods; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cars += Integer.parseInt(st.nextToken());
            cars -= Integer.parseInt(st.nextToken());

            if (cars < 0) {
                System.out.print(0);
                return;
            }

            max = Math.max(max, cars);
        }

        System.out.print(max);
    }
}
