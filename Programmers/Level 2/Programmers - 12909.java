class Solution {
    /*
     * 여는 괄호는 균형값을 늘리고 닫는 괄호는 줄인다.
     * 중간에 음수가 되면 잘못된 순서이며 마지막 균형값이 0이어야 한다.
     */
    boolean solution(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            balance += ch == '(' ? 1 : -1;
            if (balance < 0) return false;
        }

        return balance == 0;
    }
}
