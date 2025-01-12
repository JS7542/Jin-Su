class Solution {
    /*
     * 각 노래 길이의 60 나머지를 확인한다.
     * 현재 나머지와 합쳐 60이 되는 이전 나머지 빈도를 답에 더한다.
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int answer = 0;

        for (int value : time) {
            int remainder = value % 60;
            answer += count[(60 - remainder) % 60];
            count[remainder]++;
        }

        return answer;
    }
}
