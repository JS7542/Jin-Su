class Solution {
    /*
     * 번호판에서 필요한 알파벳 빈도만 대소문자 구분 없이 센다.
     * 모든 필요 빈도를 포함하는 단어 중 가장 짧은 단어를 선택한다.
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] need = new int[26];

        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') need[ch - 'a']++;
        }

        String answer = null;
        for (String word : words) {
            if ((answer == null || word.length() < answer.length()) && completes(word, need)) {
                answer = word;
            }
        }

        return answer;
    }

    private boolean completes(String word, int[] need) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()) count[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (count[i] < need[i]) return false;
        }
        return true;
    }
}
