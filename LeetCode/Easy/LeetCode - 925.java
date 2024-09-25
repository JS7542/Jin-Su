class Solution {
    /*
     * name과 typed를 각각 포인터로 순회한다.
     * typed 문자가 현재 name 문자와 같거나 직전 typed 문자 반복이면 유효하다.
     */
    public boolean isLongPressedName(String name, String typed) {
        int index = 0;

        for (int i = 0; i < typed.length(); i++) {
            if (index < name.length() && typed.charAt(i) == name.charAt(index)) {
                index++;
            } else if (i == 0 || typed.charAt(i) != typed.charAt(i - 1)) {
                return false;
            }
        }

        return index == name.length();
    }
}
