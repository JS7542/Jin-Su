import java.util.*;

class Solution {
    /*
     * 각 행의 이전·다음 행 인덱스를 배열로 관리해 이동과 삭제를 O(1)로 처리한다.
     * 삭제 행은 스택에 저장하고 복구 시 양옆 연결을 원래대로 되돌린다.
     */
    public String solution(int n, int k, String[] cmd) {
        int[] previous = new int[n];
        int[] next = new int[n];

        for (int row = 0; row < n; row++) {
            previous[row] = row - 1;
            next[row] = row + 1;
        }

        next[n - 1] = -1;

        Deque<Integer> deleted = new ArrayDeque<>();
        boolean[] removed = new boolean[n];
        int current = k;

        for (String command : cmd) {
            char type = command.charAt(0);

            if (type == 'U' || type == 'D') {
                int count = Integer.parseInt(command.substring(2));

                while (count-- > 0) {
                    current = type == 'U' ? previous[current] : next[current];
                }
            } else if (type == 'C') {
                deleted.push(current);
                removed[current] = true;

                int before = previous[current];
                int after = next[current];

                if (before != -1) next[before] = after;
                if (after != -1) previous[after] = before;

                current = after != -1 ? after : before;
            } else {
                int restored = deleted.pop();
                removed[restored] = false;

                int before = previous[restored];
                int after = next[restored];

                if (before != -1) next[before] = restored;
                if (after != -1) previous[after] = restored;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int row = 0; row < n; row++) {
            if (removed[row]) answer[row] = 'X';
        }

        return new String(answer);
    }
}
