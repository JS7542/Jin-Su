import java.io.*;
import java.util.*;

class Main {
    /*
     * 새 기기를 꽂아야 할 때 현재 꽂힌 기기들의 다음 사용 위치를 확인한다.
     * 다시 사용되지 않거나 가장 늦게 사용되는 기기를 뽑는 것이 최적이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sockets = Integer.parseInt(st.nextToken());
        int usesCount = Integer.parseInt(st.nextToken());

        int[] uses = new int[usesCount];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < usesCount; i++) {
            uses[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> plugged = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < usesCount; i++) {
            int device = uses[i];

            if (plugged.contains(device)) continue;

            if (plugged.size() < sockets) {
                plugged.add(device);
                continue;
            }

            int removeDevice = -1;
            int farthest = -1;

            for (int current : plugged) {
                int nextUse = Integer.MAX_VALUE;

                for (int next = i + 1; next < usesCount; next++) {
                    if (uses[next] == current) {
                        nextUse = next;
                        break;
                    }
                }

                if (nextUse > farthest) {
                    farthest = nextUse;
                    removeDevice = current;
                }
            }

            plugged.remove(removeDevice);
            plugged.add(device);
            answer++;
        }

        System.out.print(answer);
    }
}
