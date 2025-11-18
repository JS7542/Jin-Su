import java.util.*;

class Solution {
    /*
     * 각 직원이 워크숍에 참석하지 않는 경우와 참석하는 경우의 최소 비용을 트리 DP로 계산한다.
     * 팀장이 불참하고 모든 팀원이 불참 선택이면 추가 비용이 가장 작은 팀원 한 명을 참석시킨다.
     */
    private List<Integer>[] children;
    private int[] sales;

    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        children = new ArrayList[sales.length];

        for (int employee = 0; employee < sales.length; employee++) {
            children[employee] = new ArrayList<>();
        }

        for (int[] link : links) {
            children[link[0] - 1].add(link[1] - 1);
        }

        int[] result = search(0);
        return Math.min(result[0], result[1]);
    }

    private int[] search(int employee) {
        int absent = 0;
        int present = sales[employee];
        int smallestExtra = Integer.MAX_VALUE;
        boolean childPresentSelected = false;

        for (int child : children[employee]) {
            int[] childCost = search(child);

            if (childCost[1] < childCost[0]) {
                absent += childCost[1];
                present += childCost[1];
                childPresentSelected = true;
            } else {
                absent += childCost[0];
                present += childCost[0];
                smallestExtra = Math.min(
                        smallestExtra,
                        childCost[1] - childCost[0]
                );
            }
        }

        if (!children[employee].isEmpty() && !childPresentSelected) {
            absent += smallestExtra;
        }

        return new int[]{absent, present};
    }
}
