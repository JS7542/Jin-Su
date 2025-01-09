class Solution {
    /*
     * 정확히 세 약수를 가진 수는 소수의 제곱뿐이다.
     * n이 완전제곱수인지 확인하고 그 제곱근이 소수인지 검사한다.
     */
    public boolean isThree(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n && isPrime(root);
    }

    private boolean isPrime(int value) {
        if (value < 2) return false;

        for (int divisor = 2; divisor * divisor <= value; divisor++) {
            if (value % divisor == 0) return false;
        }

        return true;
    }
}
