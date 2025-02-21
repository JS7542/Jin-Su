class Solution {
    /*
     * 전체 원소 수가 r×c와 다르면 원본 행렬을 그대로 반환한다.
     * 일차원 인덱스를 원본과 새 행렬의 행·열 좌표로 각각 변환해 복사한다.
     */
    public int[][] matrixReshape(int[][] mat,int r,int c){int m=mat.length,n=mat[0].length;if(m*n!=r*c)return mat;int[][]a=new int[r][c];for(int i=0;i<m*n;i++)a[i/c][i%c]=mat[i/n][i%n];return a;}
}
