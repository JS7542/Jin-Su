class Solution {
    /*
     * 외계 알파벳 문자의 순위를 배열에 저장한다.
     * 인접한 단어 쌍을 외계 사전순으로 비교해 전체 정렬 여부를 확인한다.
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++) rank[order.charAt(i) - 'a'] = i;

        for (int i = 1; i < words.length; i++) {
            if (!ordered(words[i - 1], words[i], rank)) return false;
        }

        return true;
    }

    private boolean ordered(String first, String second, int[] rank) {
        int length = Math.min(first.length(), second.length());

        for (int i = 0; i < length; i++) {
            char a = first.charAt(i);
            char b = second.charAt(i);
            if (a != b) return rank[a - 'a'] < rank[b - 'a'];
        }

        return first.length() <= second.length();
    }
}
