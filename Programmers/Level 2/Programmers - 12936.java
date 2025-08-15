import java.util.*;

class Solution {
    /*
     * 남은 사람 수의 팩토리얼을 이용해 k번째 순열이 속한 묶음을 찾는다.
     * 해당 인덱스의 사람을 선택하고 k를 묶음 안의 순서로 갱신한다.
     */
    public int[] solution(int n, long k) {
        List<Integer> people = new ArrayList<>();
        for (int person = 1; person <= n; person++) people.add(person);

        long factorial = 1;
        for (int value = 2; value < n; value++) factorial *= value;

        k--;
        int[] answer = new int[n];

        for (int index = 0; index < n; index++) {
            int selected = factorial == 0 ? 0 : (int) (k / factorial);
            answer[index] = people.remove(selected);

            if (people.isEmpty()) break;

            k %= factorial;
            factorial /= people.size();
        }

        return answer;
    }
}
