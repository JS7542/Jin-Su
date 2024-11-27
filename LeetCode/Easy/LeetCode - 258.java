class Solution {
    /*
     * 반복 자릿수 합의 결과인 디지털 루트 공식을 사용한다.
     * 0은 그대로 0이고 그 외에는 1+(num-1)%9이다.
     */
    public int addDigits(int num){return num==0?0:1+(num-1)%9;}
}
