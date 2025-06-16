import java.io.*;
import java.util.*;

class Main {
    /*
     * 센서 좌표를 정렬하고 인접 센서 사이의 거리를 계산한다.
     * 집중국 K개를 배치하면 가장 큰 K-1개 간격을 끊을 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensorsCount = Integer.parseInt(br.readLine());
        int centers = Integer.parseInt(br.readLine());

        if (centers >= sensorsCount) {
            System.out.print(0);
            return;
        }

        int[] sensors = new int[sensorsCount];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sensorsCount; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        int[] gaps = new int[sensorsCount - 1];

        for (int i = 0; i + 1 < sensorsCount; i++) {
            gaps[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(gaps);

        int answer = 0;

        for (int i = 0; i < gaps.length - (centers - 1); i++) {
            answer += gaps[i];
        }

        System.out.print(answer);
    }
}
