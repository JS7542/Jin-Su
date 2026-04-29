import java.util.*;

class Solution {
    /*
     * 과반 후보를 최대 두 개 유지하는 보이어-무어 투표를 수행한다.
     * 마지막에 실제 등장 횟수를 세어 배열 길이의 1/3을 초과하는 후보만 반환한다.
     */
    public List<Integer> majorityElement(int[] nums) {
        int firstCandidate = 0;
        int secondCandidate = 1;
        int firstCount = 0;
        int secondCount = 0;

        for (int number : nums) {
            if (number == firstCandidate) {
                firstCount++;
            } else if (number == secondCandidate) {
                secondCount++;
            } else if (firstCount == 0) {
                firstCandidate = number;
                firstCount = 1;
            } else if (secondCount == 0) {
                secondCandidate = number;
                secondCount = 1;
            } else {
                firstCount--;
                secondCount--;
            }
        }

        firstCount = 0;
        secondCount = 0;

        for (int number : nums) {
            if (number == firstCandidate) firstCount++;
            else if (number == secondCandidate) secondCount++;
        }

        List<Integer> answer = new ArrayList<>();

        if (firstCount > nums.length / 3) answer.add(firstCandidate);
        if (secondCount > nums.length / 3) answer.add(secondCandidate);

        return answer;
    }
}
