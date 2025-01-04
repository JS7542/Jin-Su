class Solution {
    /*
     * 1부터 n까지의 전체 합을 계산한다.
     * 어떤 x의 제곱이 전체 합과 같으면 해당 x가 피벗 정수다.
     */
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int root = (int) Math.sqrt(total);
        return root * root == total ? root : -1;
    }
}
