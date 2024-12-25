class Solution {
    /*
     * 크기 조건과 무게 조건을 각각 boolean 값으로 계산한다.
     * 두 조건의 조합에 따라 Both, Bulky, Heavy, Neither를 반환한다.
     */
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean bulky = length >= 10000 || width >= 10000 || height >= 10000
                || volume >= 1_000_000_000L;
        boolean heavy = mass >= 100;

        if (bulky && heavy) return "Both";
        if (bulky) return "Bulky";
        if (heavy) return "Heavy";
        return "Neither";
    }
}
