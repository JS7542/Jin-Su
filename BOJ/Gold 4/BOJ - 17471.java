import java.io.*;
import java.util.*;

class Main {
    static int areas;
    static int[] population;
    static List<Integer>[] graph;
    static int answer = Integer.MAX_VALUE;

    /*
     * 지역을 두 선거구로 나누는 모든 비어 있지 않은 부분집합을 비트마스크로 확인한다.
     * 두 선거구가 각각 연결되어 있으면 인구 차이의 최솟값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        areas = Integer.parseInt(br.readLine());

        population = new int[areas];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int area = 0; area < areas; area++) {
            population[area] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[areas];

        for (int area = 0; area < areas; area++) {
            graph[area] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int i = 0; i < count; i++) {
                graph[area].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        int fullMask = (1 << areas) - 1;

        for (int firstMask = 1; firstMask < fullMask; firstMask++) {
            int secondMask = fullMask ^ firstMask;

            if (firstMask > secondMask) continue;
            if (!connected(firstMask) || !connected(secondMask)) continue;

            int firstPopulation = 0;
            int secondPopulation = 0;

            for (int area = 0; area < areas; area++) {
                if ((firstMask & (1 << area)) != 0) {
                    firstPopulation += population[area];
                } else {
                    secondPopulation += population[area];
                }
            }

            answer = Math.min(
                    answer,
                    Math.abs(firstPopulation - secondPopulation)
            );
        }

        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean connected(int mask) {
        int start = Integer.numberOfTrailingZeros(mask);
        int visitedMask = 1 << start;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                int bit = 1 << next;

                if ((mask & bit) == 0 || (visitedMask & bit) != 0) continue;

                visitedMask |= bit;
                queue.offer(next);
            }
        }

        return visitedMask == mask;
    }
}
