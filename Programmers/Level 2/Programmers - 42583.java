import java.util.*;

class Solution {
    /*
     * 다리 위 각 칸을 큐로 표현하고 매초 맨 앞 칸을 제거한다.
     * 다음 트럭을 올릴 수 있으면 큐에 넣고 아니면 빈 칸을 추가한다.
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) bridge.offer(0);

        int time = 0;
        int currentWeight = 0;
        int index = 0;

        while (index < truck_weights.length || currentWeight > 0) {
            time++;
            currentWeight -= bridge.poll();

            if (index < truck_weights.length
                    && currentWeight + truck_weights[index] <= weight) {
                currentWeight += truck_weights[index];
                bridge.offer(truck_weights[index++]);
            } else {
                bridge.offer(0);
            }
        }

        return time;
    }
}
