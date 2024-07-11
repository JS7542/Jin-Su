import java.io.*;
import java.util.*;

class Main {
    /*
     * D의 배수인 전화 시간을 앞에서부터 확인한다.
     * 전화 시각이 어느 노래 재생 구간에도 포함되지 않으면 그 시각을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int songs = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken());

        for (int ring = 0; ; ring += interval) {
            boolean playing = false;

            for (int song = 0; song < songs; song++) {
                int start = song * (length + 5);

                if (start <= ring && ring < start + length) {
                    playing = true;
                    break;
                }
            }

            if (!playing) {
                System.out.print(ring);
                return;
            }
        }
    }
}
