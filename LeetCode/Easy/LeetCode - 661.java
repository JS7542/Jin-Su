class Solution {
    /*
     * 각 셀을 중심으로 범위 안에 있는 주변 3×3 셀의 합과 개수를 구한다.
     * 평균의 소수점을 버린 값을 새 행렬의 같은 위치에 저장한다.
     */
    public int[][] imageSmoother(int[][] img){int m=img.length,n=img[0].length;int[][]r=new int[m][n];for(int i=0;i<m;i++)for(int j=0;j<n;j++){int sum=0,c=0;for(int x=Math.max(0,i-1);x<=Math.min(m-1,i+1);x++)for(int y=Math.max(0,j-1);y<=Math.min(n-1,j+1);y++){sum+=img[x][y];c++;}r[i][j]=sum/c;}return r;}
}
