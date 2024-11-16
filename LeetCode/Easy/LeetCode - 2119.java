class Solution {
    /*
     * 두 번 뒤집어도 같은 수가 되려면 원래 수의 끝자리가 0이 아니어야 한다.
     * 단, 숫자 0은 뒤집어도 그대로이므로 예외적으로 true다.
     */
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}
