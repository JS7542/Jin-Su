import java.io.*;
import java.util.*;

class Main {
    /*
     * 세 막대가 모두 같으면 정삼각형이므로 2를 출력한다.
     * 정렬 후 피타고라스 식을 만족하면 1, 그 외에는 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sticks = new int[3];

        for (int i = 0; i < 3; i++) sticks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sticks);

        if (sticks[0] == sticks[2]) {
            System.out.print(2);
        } else if (sticks[0] * sticks[0] + sticks[1] * sticks[1]
                == sticks[2] * sticks[2]) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
