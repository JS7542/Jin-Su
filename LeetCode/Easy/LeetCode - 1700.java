import java.util.*;

class Solution {
    /*
     * 학생 선호를 큐에 저장하고 현재 샌드위치를 먹지 못하면 뒤로 보낸다.
     * 한 바퀴 동안 아무도 먹지 못하면 남은 학생 수를 반환한다.
     */
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int student : students) queue.offer(student);

        int sandwich = 0;
        int skipped = 0;

        while (!queue.isEmpty() && skipped < queue.size()) {
            if (queue.peek() == sandwiches[sandwich]) {
                queue.poll();
                sandwich++;
                skipped = 0;
            } else {
                queue.offer(queue.poll());
                skipped++;
            }
        }

        return queue.size();
    }
}
