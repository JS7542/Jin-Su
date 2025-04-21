import java.util.*;

class Solution {
    /*
     * 항공권을 도착 공항 사전순으로 정렬한다.
     * ICN에서 시작해 모든 항공권을 한 번씩 사용하는 첫 경로를 백트래킹으로 찾는다.
     */
    private String[][] tickets;
    private boolean[] used;
    private String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (first, second) -> {
            int from = first[0].compareTo(second[0]);
            return from != 0 ? from : first[1].compareTo(second[1]);
        });

        this.tickets = tickets;
        used = new boolean[tickets.length];

        List<String> route = new ArrayList<>();
        route.add("ICN");
        search("ICN", route);

        return answer;
    }

    private boolean search(String current, List<String> route) {
        if (route.size() == tickets.length + 1) {
            answer = route.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i] || !tickets[i][0].equals(current)) continue;

            used[i] = true;
            route.add(tickets[i][1]);

            if (search(tickets[i][1], route)) return true;

            route.remove(route.size() - 1);
            used[i] = false;
        }

        return false;
    }
}
