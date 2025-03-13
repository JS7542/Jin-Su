class Solution {
    /*
     * word를 한 번씩 더 이어 붙이며 sequence에 포함되는지 확인한다.
     * 포함되지 않는 순간 직전 반복 횟수를 반환한다.
     */
    public int maxRepeating(String sequence, String word) {
        String repeated = word;
        int count = 0;

        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }

        return count;
    }
}
