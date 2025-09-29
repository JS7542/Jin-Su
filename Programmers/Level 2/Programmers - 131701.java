import java.util.*;

class Solution {
    /*
     * 원형 수열을 두 번 이어 붙인 것으로 생각한다.
     * 각 길이와 시작점의 연속합을 계산해 해시셋에 넣고 서로 다른 합의 개수를 반환한다.
     */
    public int solution(int[] elements) {
        int length = elements.length;
        int[] doubled = new int[length * 2];

        for (int i = 0; i < doubled.length; i++) {
            doubled[i] = elements[i % length];
        }

        int[] prefix = new int[doubled.length + 1];

        for (int i = 0; i < doubled.length; i++) {
            prefix[i + 1] = prefix[i] + doubled[i];
        }

        Set<Integer> sums = new HashSet<>();

        for (int size = 1; size <= length; size++) {
            for (int start = 0; start < length; start++) {
                sums.add(prefix[start + size] - prefix[start]);
            }
        }

        return sums.size();
    }
}
