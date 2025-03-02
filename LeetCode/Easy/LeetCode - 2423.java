class Solution {
    /*
     * 각 위치의 문자를 하나 제거했다고 가정하고 빈도수를 다시 계산한다.
     * 남은 문자들의 양수 빈도가 모두 같아지는 경우가 있으면 true다.
     */
    public boolean equalFrequency(String word) {
        for (int removed = 0; removed < word.length(); removed++) {
            int[] count = new int[26];

            for (int i = 0; i < word.length(); i++) {
                if (i != removed) count[word.charAt(i) - 'a']++;
            }

            int frequency = 0;
            boolean valid = true;

            for (int value : count) {
                if (value == 0) continue;
                if (frequency == 0) frequency = value;
                else if (frequency != value) valid = false;
            }

            if (valid) return true;
        }

        return false;
    }
}
