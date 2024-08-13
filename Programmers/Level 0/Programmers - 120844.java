class Solution {
    /*
     * 오른쪽 회전은 마지막 값을 맨 앞으로, 왼쪽 회전은 첫 값을 맨 뒤로 이동한다.
     * 각 원소의 새 위치를 모듈러 연산으로 계산해 배열을 만든다.
     */
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] answer = new int[n];

        if (direction.equals("right")) {
            for (int i = 0; i < n; i++) answer[(i + 1) % n] = numbers[i];
        } else {
            for (int i = 0; i < n; i++) answer[i] = numbers[(i + 1) % n];
        }

        return answer;
    }
}
