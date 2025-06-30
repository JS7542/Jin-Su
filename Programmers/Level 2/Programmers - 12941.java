import java.util.*;

class Solution {
    /*
     * 한 배열은 오름차순, 다른 배열은 오름차순 정렬 후 반대 방향으로 짝지어 곱한다.
     * 큰 수와 작은 수를 대응시키면 곱의 합이 최소가 된다.
     */
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}
