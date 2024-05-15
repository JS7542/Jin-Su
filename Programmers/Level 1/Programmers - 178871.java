import java.util.*;

class Solution {
    /*
     * 선수 이름별 현재 순위를 해시맵에 저장한다.
     * 호출된 선수와 바로 앞 선수를 배열에서 교환하고 두 순위를 갱신한다.
     */
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) rank.put(players[i], i);

        for (String called : callings) {
            int current = rank.get(called);
            String front = players[current - 1];

            players[current - 1] = called;
            players[current] = front;
            rank.put(called, current - 1);
            rank.put(front, current);
        }

        return players;
    }
}
