class Solution {
    /*
     * 1부터 n까지 순회하며 n을 나누어떨어지게 하는 수를 찾는다.
     * 모든 약수를 합산해 반환한다.
     */
    public int solution(int n){int answer=0;for(int i=1;i<=n;i++)if(n%i==0)answer+=i;return answer;}
}
