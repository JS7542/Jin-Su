import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 번의 포획 수와 두 번 모두 포획된 수를 보정 공식에 대입한다.
     * (N1+1)(N2+1)/(N12+1)-1의 정수 결과를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int both = Integer.parseInt(st.nextToken());

        System.out.print((first + 1) * (second + 1) / (both + 1) - 1);
    }
}
