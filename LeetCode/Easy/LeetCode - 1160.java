class Solution {
    /*
     * chars의 알파벳 빈도를 기준 배열에 저장한다.
     * 각 단어가 필요한 빈도를 모두 만족하면 단어 길이를 결과에 더한다.
     */
    public int countCharacters(String[] words, String chars) {
        int[] available = count(chars);
        int answer = 0;

        for (String word : words) {
            int[] need = count(word);
            boolean possible = true;

            for (int i = 0; i < 26; i++) {
                if (need[i] > available[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) answer += word.length();
        }

        return answer;
    }

    private int[] count(String text) {
        int[] count = new int[26];
        for (char ch : text.toCharArray()) count[ch - 'a']++;
        return count;
    }
}
