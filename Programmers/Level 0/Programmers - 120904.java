class Solution {
    /*
     * 정수 num을 문자열로 바꾸고 숫자 k의 첫 등장 위치를 찾는다.
     * indexOf 결과에 1을 더하되 존재하지 않으면 -1을 반환한다.
     */
    public int solution(int num,int k){int i=String.valueOf(num).indexOf(String.valueOf(k));return i<0?-1:i+1;}
}
