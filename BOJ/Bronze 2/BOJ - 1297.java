import java.io.*;
import java.util.*;

class Main {
    /*
     * 대각선 길이와 화면 비율로 실제 비율 배수를 계산한다.
     * 비율의 높이와 너비에 배수를 곱한 정수 부분을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int diagonal = Integer.parseInt(st.nextToken());
        int heightRatio = Integer.parseInt(st.nextToken());
        int widthRatio = Integer.parseInt(st.nextToken());

        double scale = diagonal / Math.sqrt(
                heightRatio * heightRatio + widthRatio * widthRatio
        );

        System.out.print((int) (heightRatio * scale) + " " + (int) (widthRatio * scale));
    }
}
