class Solution {
    /*
     * 앞의 두 boolean을 OR 연산하고 뒤의 두 boolean도 OR 연산한다.
     * 두 OR 결과를 AND 연산한 값을 반환한다.
     */
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }
}
