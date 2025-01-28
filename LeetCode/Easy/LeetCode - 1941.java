class Solution {
    /*
     * 각 소문자의 등장 횟수를 센다.
     * 등장한 문자들의 빈도가 모두 첫 빈도와 같은지 확인한다.
     */
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;

        int frequency = 0;

        for (int value : count) {
            if (value == 0) continue;
            if (frequency == 0) frequency = value;
            else if (frequency != value) return false;
        }

        return true;
    }
}
