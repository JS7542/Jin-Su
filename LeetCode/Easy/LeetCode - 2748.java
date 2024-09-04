class Solution {
    /*
     * 앞 숫자의 첫 자리와 뒤 숫자의 마지막 자리의 최대공약수를 구한다.
     * 최대공약수가 1인 인덱스 쌍의 개수를 센다.
     */
    public int countBeautifulPairs(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];

            while (first >= 10) first /= 10;

            for (int j = i + 1; j < nums.length; j++) {
                int last = nums[j] % 10;
                if (gcd(first, last) == 1) answer++;
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
