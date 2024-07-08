class Solution {
    /*
     * a와 b 중 작은 값부터 큰 값까지의 등차수열 합을 계산한다.
     * 항의 개수와 양 끝 합을 long으로 곱해 2로 나눈다.
     */
    public long solution(int a,int b){long min=Math.min(a,b),max=Math.max(a,b);return (min+max)*(max-min+1)/2;}
}
