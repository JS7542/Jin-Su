class Solution {
    /*
     * 문제 규칙에 따라 배열을 반복 변환한다.
     * 한 번의 변환에서도 값이 바뀌지 않는 최초 반복 횟수를 반환한다.
     */
    public int solution(int[] arr) {
        int count = 0;

        while (true) {
            boolean changed = false;

            for (int i = 0; i < arr.length; i++) {
                int next = arr[i];

                if (arr[i] >= 50 && arr[i] % 2 == 0) next = arr[i] / 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) next = arr[i] * 2 + 1;

                if (next != arr[i]) changed = true;
                arr[i] = next;
            }

            if (!changed) return count;
            count++;
        }
    }
}
