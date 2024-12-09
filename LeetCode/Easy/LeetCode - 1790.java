class Solution {
    /*
     * 두 문자열에서 서로 다른 위치를 최대 두 개까지 기록한다.
     * 차이가 없거나 정확히 두 위치의 문자가 교차해서 같으면 한 번의 교환으로 만들 수 있다.
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int first = -1;
        int second = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;

            if (first == -1) first = i;
            else if (second == -1) second = i;
            else return false;
        }

        if (first == -1) return true;
        return second != -1
                && s1.charAt(first) == s2.charAt(second)
                && s1.charAt(second) == s2.charAt(first);
    }
}
