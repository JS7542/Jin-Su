class Solution {
    /*
     * 배열 길이가 11 이상이면 모든 원소의 합을 계산한다.
     * 길이가 10 이하이면 모든 원소의 곱을 계산한다.
     */
    public int solution(int[] num_list) {
        if (num_list.length >= 11) {
            int sum = 0;
            for (int number : num_list) sum += number;
            return sum;
        }

        int product = 1;
        for (int number : num_list) product *= number;
        return product;
    }
}
