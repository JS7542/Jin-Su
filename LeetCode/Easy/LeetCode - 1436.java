import java.util.*;

class Solution {
    /*
     * 모든 출발 도시를 해시셋에 저장한다.
     * 경로의 도착 도시 중 출발 도시 집합에 없는 도시가 최종 목적지다.
     */
    public String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        for (List<String> path : paths) starts.add(path.get(0));

        for (List<String> path : paths) {
            if (!starts.contains(path.get(1))) return path.get(1);
        }

        return "";
    }
}
