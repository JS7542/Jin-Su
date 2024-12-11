class Solution {
    /*
     * 섭씨 온도를 켈빈과 화씨 공식에 각각 대입한다.
     * 켈빈, 화씨 순서의 double 배열을 반환한다.
     */
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32.0};
    }
}
