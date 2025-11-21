import java.util.*;

class Solution {
    /*
     * 단어를 길이별 정방향 목록과 뒤집은 목록에 저장하고 정렬한다.
     * 와일드카드가 뒤에 있으면 정방향, 앞에 있으면 뒤집은 목록에서 이분 탐색한다.
     */
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> normal = new HashMap<>();
        Map<Integer, List<String>> reversed = new HashMap<>();

        for (String word : words) {
            normal.computeIfAbsent(word.length(), key -> new ArrayList<>())
                    .add(word);
            reversed.computeIfAbsent(word.length(), key -> new ArrayList<>())
                    .add(new StringBuilder(word).reverse().toString());
        }

        for (List<String> list : normal.values()) Collections.sort(list);
        for (List<String> list : reversed.values()) Collections.sort(list);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            boolean prefixWildcard = query.charAt(0) == '?';

            if (prefixWildcard) query = new StringBuilder(query).reverse().toString();

            List<String> list = (prefixWildcard ? reversed : normal)
                    .getOrDefault(query.length(), Collections.emptyList());

            String lower = query.replace('?', 'a');
            String upper = query.replace('?', 'z');

            answer[i] = lowerBound(list, upper + "{") - lowerBound(list, lower);
        }

        return answer;
    }

    private int lowerBound(List<String> list, String target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid).compareTo(target) < 0) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
