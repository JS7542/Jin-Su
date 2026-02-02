import java.util.*;

class Solution {
    /*
     * 두 배열을 오름차순으로 정렬한다.
     * B의 현재 수가 A의 현재 수보다 클 때 승점을 얻고 두 포인터를 함께 이동한다.
     */
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int answer = 0;

        for (int value : B) {
            if (aIndex < A.length && value > A[aIndex]) {
                answer++;
                aIndex++;
            }
        }

        return answer;
    }
}
