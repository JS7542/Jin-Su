class Solution {
    /*
     * 왼쪽에서 가장 최근 c 위치와 오른쪽에서 가장 가까운 c 위치까지 거리를 각각 계산한다.
     * 두 방향 거리의 최솟값을 각 인덱스의 답으로 저장한다.
     */
    public int[] shortestToChar(String s,char c){int n=s.length(),prev=-n;int[]a=new int[n];for(int i=0;i<n;i++){if(s.charAt(i)==c)prev=i;a[i]=i-prev;}prev=2*n;for(int i=n-1;i>=0;i--){if(s.charAt(i)==c)prev=i;a[i]=Math.min(a[i],prev-i);}return a;}
}
