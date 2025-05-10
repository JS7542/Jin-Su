import java.util.*;

class Solution {
    /*
     * 과제를 시작 시각순으로 정렬하고 새 과제 전까지 진행 가능한 시간을 계산한다.
     * 중단된 과제는 스택에 저장해 가장 최근 과제부터 남은 시간만큼 이어서 수행한다.
     */
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparing(plan -> plan[1]));

        Deque<Task> paused = new ArrayDeque<>();
        List<String> completed = new ArrayList<>();

        for (int index = 0; index < plans.length; index++) {
            String name = plans[index][0];
            int start = minutes(plans[index][1]);
            int duration = Integer.parseInt(plans[index][2]);
            int nextStart = index + 1 < plans.length
                    ? minutes(plans[index + 1][1])
                    : Integer.MAX_VALUE;

            int available = nextStart - start;

            if (duration <= available) {
                completed.add(name);
                available -= duration;

                while (available > 0 && !paused.isEmpty()) {
                    Task task = paused.pop();

                    if (task.remaining <= available) {
                        available -= task.remaining;
                        completed.add(task.name);
                    } else {
                        task.remaining -= available;
                        paused.push(task);
                        available = 0;
                    }
                }
            } else {
                paused.push(new Task(name, duration - available));
            }
        }

        while (!paused.isEmpty()) completed.add(paused.pop().name);

        return completed.toArray(new String[0]);
    }

    private int minutes(String time) {
        String[] parts = time.split(":");

        return Integer.parseInt(parts[0]) * 60
                + Integer.parseInt(parts[1]);
    }

    private static class Task {
        String name;
        int remaining;

        Task(String name, int remaining) {
            this.name = name;
            this.remaining = remaining;
        }
    }
}
