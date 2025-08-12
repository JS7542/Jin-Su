class Solution {
    /*
     * 결과 문자열을 단조 감소 스택처럼 사용한다.
     * 더 큰 숫자를 만나면 제거 횟수 범위 안에서 앞의 작은 숫자를 삭제한다.
     */
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();

        for (char digit : number.toCharArray()) {
            while (k > 0 && stack.length() > 0
                    && stack.charAt(stack.length() - 1) < digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        return stack.substring(0, stack.length() - k);
    }
}
