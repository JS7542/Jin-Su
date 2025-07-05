import java.util.*;

class Solution {
    /*
     * 도시 이름을 소문자로 통일하고 LRU 순서를 리스트로 관리한다.
     * 캐시 적중 시 1, 미스 시 5를 더하고 가장 오래된 항목을 제거한다.
     */
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        List<String> cache = new ArrayList<>();
        int time = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            int index = cache.indexOf(city);

            if (index >= 0) {
                cache.remove(index);
                time += 1;
            } else {
                if (cache.size() == cacheSize) cache.remove(0);
                time += 5;
            }

            cache.add(city);
        }

        return time;
    }
}
