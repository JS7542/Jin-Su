class Solution {
    /*
     * myString의 A는 B로, B는 A로 서로 바꾼 문자열을 만든다.
     * 변환한 문자열에 pat이 포함되면 1, 아니면 0을 반환한다.
     */
    public int solution(String myString, String pat) {
        StringBuilder changed = new StringBuilder();

        for (char ch : myString.toCharArray()) {
            changed.append(ch == 'A' ? 'B' : 'A');
        }

        return changed.toString().contains(pat) ? 1 : 0;
    }
}
