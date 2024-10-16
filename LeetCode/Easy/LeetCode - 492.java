class Solution {
    /*
     * 넓이의 제곱근 이하에서 가장 큰 약수를 W로 찾는다.
     * L=area/W로 계산하면 L>=W이며 두 값 차이가 최소다.
     */
    public int[] constructRectangle(int area){int w=(int)Math.sqrt(area);while(area%w!=0)w--;return new int[]{area/w,w};}
}
