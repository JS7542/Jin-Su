import java.util.*;

class Solution {
    /*
     * 첫 열, 마지막 열, 가운데 행들을 각각 덱으로 분리한다.
     * ShiftRow는 세 덱의 행 단위를 회전하고 Rotate는 바깥 테두리 값만 이동시킨다.
     */
    public int[][] solution(int[][] rc, String[] operations) {
        int rows = rc.length;
        int cols = rc[0].length;

        Deque<Integer> leftColumn = new ArrayDeque<>();
        Deque<Integer> rightColumn = new ArrayDeque<>();
        Deque<Deque<Integer>> middleRows = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            leftColumn.offerLast(rc[row][0]);
            rightColumn.offerLast(rc[row][cols - 1]);

            Deque<Integer> middle = new ArrayDeque<>();

            for (int col = 1; col < cols - 1; col++) {
                middle.offerLast(rc[row][col]);
            }

            middleRows.offerLast(middle);
        }

        for (String operation : operations) {
            if (operation.equals("ShiftRow")) {
                leftColumn.offerFirst(leftColumn.pollLast());
                rightColumn.offerFirst(rightColumn.pollLast());
                middleRows.offerFirst(middleRows.pollLast());
            } else {
                Deque<Integer> top = middleRows.peekFirst();
                Deque<Integer> bottom = middleRows.peekLast();

                top.offerFirst(leftColumn.pollFirst());
                rightColumn.offerFirst(top.pollLast());
                bottom.offerLast(rightColumn.pollLast());
                leftColumn.offerLast(bottom.pollFirst());
            }
        }

        int[][] answer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            answer[row][0] = leftColumn.pollFirst();
            answer[row][cols - 1] = rightColumn.pollFirst();

            Deque<Integer> middle = middleRows.pollFirst();

            for (int col = 1; col < cols - 1; col++) {
                answer[row][col] = middle.pollFirst();
            }
        }

        return answer;
    }
}
