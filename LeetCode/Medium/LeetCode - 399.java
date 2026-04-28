import java.util.*;

class Solution {
    /*
     * 변수 사이 나눗셈 관계를 양방향 가중치 그래프로 만든다.
     * 각 질의마다 시작 변수에서 목표 변수까지 DFS하며 간선 가중치 곱을 계산한다.
     */
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int index = 0; index < equations.size(); index++) {
            String first = equations.get(index).get(0);
            String second = equations.get(index).get(1);

            graph.computeIfAbsent(first, key -> new ArrayList<>())
                    .add(new Edge(second, values[index]));
            graph.computeIfAbsent(second, key -> new ArrayList<>())
                    .add(new Edge(first, 1.0 / values[index]));
        }

        double[] answer = new double[queries.size()];

        for (int index = 0; index < queries.size(); index++) {
            String start = queries.get(index).get(0);
            String target = queries.get(index).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(target)) {
                answer[index] = -1.0;
            } else {
                answer[index] = search(
                        start,
                        target,
                        1.0,
                        new HashSet<>(),
                        graph
                );
            }
        }

        return answer;
    }

    private double search(
            String current,
            String target,
            double value,
            Set<String> visited,
            Map<String, List<Edge>> graph
    ) {
        if (current.equals(target)) return value;

        visited.add(current);

        for (Edge edge : graph.get(current)) {
            if (visited.contains(edge.to)) continue;

            double result = search(
                    edge.to,
                    target,
                    value * edge.weight,
                    visited,
                    graph
            );

            if (result >= 0) return result;
        }

        return -1.0;
    }

    private static class Edge {
        String to;
        double weight;

        Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
