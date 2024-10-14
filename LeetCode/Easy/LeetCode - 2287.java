class Solution {
    /*
     * s와 target의 알파벳 빈도수를 각각 센다.
     * target에 필요한 각 문자로 만들 수 있는 횟수의 최솟값을 반환한다.
     */
    public int rearrangeCharacters(String s, String target) {
        int[] available = new int[26];
        int[] need = new int[26];

        for (char ch : s.toCharArray()) available[ch - 'a']++;
        for (char ch : target.toCharArray()) need[ch - 'a']++;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) answer = Math.min(answer, available[i] / need[i]);
        }

        return answer;
    }
}
