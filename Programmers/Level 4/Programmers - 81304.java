import java.util.*;

class Solution {
    /*
     * 현재 방과 함정 활성화 비트마스크를 다익스트라 상태로 사용한다.
     * 간선의 원래 방향과 양 끝 함정 활성 상태의 XOR로 현재 이동 가능 방향을 판단한다.
     */
    public int solution(
            int n,
            int start,
            int end,
            int[][] roads,
            int[] traps
    ) {
        Map<Integer, Integer> trapIndex = new HashMap<>();

        for (int index = 0; index < traps.length; index++) {
            trapIndex.put(traps[index], index);
        }

        List<Edge>[] graph = new ArrayList[n + 1];

        for (int room = 1; room <= n; room++) graph[room] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(new Edge(road[1], road[2], false));
            graph[road[1]].add(new Edge(road[0], road[2], true));
        }

        int states = 1 << traps.length;
        int[][] distance = new int[n + 1][states];

        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<State> queue = new PriorityQueue<>(
                Comparator.comparingInt(state -> state.cost)
        );

        distance[start][0] = 0;
        queue.offer(new State(start, 0, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.cost != distance[current.room][current.mask]) continue;
            if (current.room == end) return current.cost;

            boolean currentActive = active(
                    current.room,
                    current.mask,
                    trapIndex
            );

            for (Edge edge : graph[current.room]) {
                boolean nextActive = active(
                        edge.to,
                        current.mask,
                        trapIndex
                );
                boolean reversed = currentActive ^ nextActive;

                if (edge.reverse != reversed) continue;

                int nextMask = current.mask;

                if (trapIndex.containsKey(edge.to)) {
                    nextMask ^= 1 << trapIndex.get(edge.to);
                }

                int nextCost = current.cost + edge.cost;

                if (nextCost < distance[edge.to][nextMask]) {
                    distance[edge.to][nextMask] = nextCost;
                    queue.offer(new State(edge.to, nextMask, nextCost));
                }
            }
        }

        return -1;
    }

    private boolean active(
            int room,
            int mask,
            Map<Integer, Integer> trapIndex
    ) {
        Integer index = trapIndex.get(room);

        return index != null && (mask & (1 << index)) != 0;
    }

    private static class Edge {
        int to;
        int cost;
        boolean reverse;

        Edge(int to, int cost, boolean reverse) {
            this.to = to;
            this.cost = cost;
            this.reverse = reverse;
        }
    }

    private static class State {
        int room;
        int mask;
        int cost;

        State(int room, int mask, int cost) {
            this.room = room;
            this.mask = mask;
            this.cost = cost;
        }
    }
}
