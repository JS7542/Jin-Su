import java.util.*;

class Solution {
    /*
     * 장르별 총 재생 수와 장르 안의 곡 목록을 함께 저장한다.
     * 장르 총합 내림차순, 곡 재생 수 내림차순과 고유 번호 오름차순으로 선택한다.
     */
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totals = new HashMap<>();
        Map<String, List<Integer>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totals.put(genres[i], totals.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(i);
        }

        List<String> orderedGenres = new ArrayList<>(totals.keySet());
        orderedGenres.sort((a, b) -> Integer.compare(totals.get(b), totals.get(a)));

        List<Integer> answer = new ArrayList<>();

        for (String genre : orderedGenres) {
            List<Integer> indices = songs.get(genre);
            indices.sort((a, b) -> {
                int compare = Integer.compare(plays[b], plays[a]);
                return compare != 0 ? compare : Integer.compare(a, b);
            });

            answer.add(indices.get(0));
            if (indices.size() > 1) answer.add(indices.get(1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
