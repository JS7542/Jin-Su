import java.util.*;

class Solution {
    /*
     * begin에서 한 글자만 다른 단어로 이동하는 BFS를 수행한다.
     * target을 처음 방문한 단계가 최소 변환 횟수다.
     */
    public int solution(String begin, String target, String[] words) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        int[] distance = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (differentByOne(begin, words[i])) {
                visited[i] = true;
                distance[i] = 1;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (words[current].equals(target)) return distance[current];

            for (int next = 0; next < words.length; next++) {
                if (!visited[next] && differentByOne(words[current], words[next])) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    private boolean differentByOne(String first, String second) {
        int difference = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i) && ++difference > 1) return false;
        }

        return difference == 1;
    }
}
