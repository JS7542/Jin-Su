class Solution {
    /*
     * 1의 구간이 끝난 뒤 다시 1이 나오면 문자열에 01 패턴이 존재한다.
     * 01이 없으면 1로 이루어진 연속 구간은 최대 하나다.
     */
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
