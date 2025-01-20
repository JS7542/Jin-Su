class Solution {
    /*
     * 1과 제곱근까지의 약수 쌍을 이용해 자기 자신을 제외한 약수 합을 구한다.
     * 합이 원래 수와 같은지 확인한다.
     */
    public boolean checkPerfectNumber(int num){if(num<=1)return false;int sum=1;for(int i=2;i*i<=num;i++)if(num%i==0){sum+=i;if(i*i!=num)sum+=num/i;}return sum==num;}
}
