class Solution {
    /*
     * b가 등장한 뒤 다시 a가 등장하면 조건을 위반한다.
     * 문자열에 ba 패턴이 없으면 모든 a가 b보다 앞에 있다.
     */
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
