class Solution {
    /*
     * 세 수의 같은 자리 숫자 중 최솟값을 선택한다.
     * 일의 자리부터 네 자리까지 처리해 하나의 키를 만든다.
     */
    public int generateKey(int num1, int num2, int num3) {
        int key = 0;
        int place = 1;

        for (int i = 0; i < 4; i++) {
            int digit = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
            key += digit * place;
            place *= 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        return key;
    }
}
