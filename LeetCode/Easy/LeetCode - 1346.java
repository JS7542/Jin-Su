import java.util.*;

class Solution {
    /*
     * 이전에 본 숫자를 해시셋에 저장한다.
     * 현재 값의 두 배 또는 현재 값이 짝수일 때 절반이 집합에 있으면 조건을 만족한다.
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int value : arr) {
            if (seen.contains(value * 2) || (value % 2 == 0 && seen.contains(value / 2))) {
                return true;
            }
            seen.add(value);
        }

        return false;
    }
}
