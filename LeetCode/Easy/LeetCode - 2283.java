class Solution {
    /*
     * num 문자열에 등장하는 각 숫자의 빈도수를 센다.
     * i번째 문자가 요구하는 값과 숫자 i의 실제 빈도가 같은지 확인한다.
     */
    public boolean digitCount(String num) {
        int[] count = new int[10];
        for (char ch : num.toCharArray()) count[ch - '0']++;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != count[i]) return false;
        }

        return true;
    }
}
