class Solution {
    /*
     * 각 풍선 왼쪽의 최솟값과 오른쪽의 최솟값을 계산한다.
     * 현재 값이 양쪽 최솟값보다 모두 크면 끝까지 남을 수 없고, 아니면 남을 수 있다.
     */
    public int solution(int[] a) {
        if (a.length <= 2) return a.length;

        int[] leftMinimum = new int[a.length];
        int[] rightMinimum = new int[a.length];

        leftMinimum[0] = a[0];

        for (int index = 1; index < a.length; index++) {
            leftMinimum[index] = Math.min(
                    leftMinimum[index - 1],
                    a[index]
            );
        }

        rightMinimum[a.length - 1] = a[a.length - 1];

        for (int index = a.length - 2; index >= 0; index--) {
            rightMinimum[index] = Math.min(
                    rightMinimum[index + 1],
                    a[index]
            );
        }

        int answer = 0;

        for (int index = 0; index < a.length; index++) {
            if (a[index] <= leftMinimum[index]
                    || a[index] <= rightMinimum[index]) {
                answer++;
            }
        }

        return answer;
    }
}
