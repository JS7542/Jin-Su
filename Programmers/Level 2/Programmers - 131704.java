import java.util.*;

class Solution {
    /*
     * 기본 컨테이너 벨트의 상자를 1번부터 차례로 처리한다.
     * 원하는 순서가 아니면 보조 스택에 넣고, 스택 위가 원하는 상자일 때 계속 꺼낸다.
     */
    public int solution(int[] order) {
        Deque<Integer> auxiliary = new ArrayDeque<>();
        int orderIndex = 0;

        for (int box = 1; box <= order.length; box++) {
            auxiliary.push(box);

            while (!auxiliary.isEmpty()
                    && orderIndex < order.length
                    && auxiliary.peek() == order[orderIndex]) {
                auxiliary.pop();
                orderIndex++;
            }
        }

        return orderIndex;
    }
}
