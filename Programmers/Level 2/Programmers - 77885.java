class Solution {
    /*
     * 짝수는 마지막 비트 0을 1로 바꾸면 바로 다음 조건 만족 수가 된다.
     * 홀수는 가장 낮은 0비트를 1로 바꾸고 그 바로 아래 1비트를 0으로 바꾼다.
     */
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            if ((number & 1L) == 0) {
                answer[i] = number + 1;
            } else {
                long zeroBit = 1L;

                while ((number & zeroBit) != 0) zeroBit <<= 1;

                answer[i] = number + zeroBit - (zeroBit >> 1);
            }
        }

        return answer;
    }
}
