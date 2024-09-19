class Solution {
    /*
     * n의 일의 자리를 반복해서 더하고 n을 10으로 나눈다.
     * 모든 자릿수를 처리한 합을 반환한다.
     */
    public int solution(int n){int answer=0;while(n>0){answer+=n%10;n/=10;}return answer;}
}
