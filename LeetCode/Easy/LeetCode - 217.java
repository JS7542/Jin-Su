import java.util.*;

class Solution {
    /*
     * 숫자를 해시셋에 하나씩 추가한다.
     * 이미 존재해 추가되지 않는 숫자를 만나면 중복이 있으므로 true를 반환한다.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int number : nums) {
            if (!seen.add(number)) return true;
        }
        return false;
    }
}
