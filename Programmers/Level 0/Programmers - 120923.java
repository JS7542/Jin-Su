class Solution {
    /*
     * n개의 연속된 수의 시작값을 total/n-(n-1)/2로 계산한다.
     * 시작값부터 1씩 증가시키며 길이 n 배열을 만든다.
     */
    public int[] solution(int num,int total){int start=total/num-(num-1)/2;int[]a=new int[num];for(int i=0;i<num;i++)a[i]=start+i;return a;}
}
