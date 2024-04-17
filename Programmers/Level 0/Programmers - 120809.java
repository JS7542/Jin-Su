class Solution {
    /*
     * 입력 배열의 각 원소를 두 배로 계산한다.
     * 같은 길이의 새 배열에 결과를 저장해 반환한다.
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) answer[i] = numbers[i] * 2;
        return answer;
    }
}
