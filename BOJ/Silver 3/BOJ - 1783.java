import java.io.*;
import java.util.*;

class Main {
    /*
     * 세로가 1이면 이동할 수 없고, 세로가 2면 두 종류 이동만 사용할 수 있다.
     * 세로가 3 이상이면 가로 길이에 따라 네 이동을 모두 사용 가능한지 나눈다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int answer;

        if (height == 1) {
            answer = 1;
        } else if (height == 2) {
            answer = Math.min(4, (width + 1) / 2);
        } else if (width < 7) {
            answer = Math.min(4, width);
        } else {
            answer = width - 2;
        }

        System.out.print(answer);
    }
}
