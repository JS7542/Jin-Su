class Solution {
    /*
     * 각 행의 양 끝 값을 서로 반전시켜 교환하면 수평 뒤집기와 비트 반전을 동시에 처리한다.
     * 가운데 셀이 있는 경우 자기 자신과 교환하며 한 번만 반전된다.
     */
    public int[][] flipAndInvertImage(int[][] image){for(int[]row:image)for(int l=0,r=row.length-1;l<=r;l++,r--){int left=row[l]^1,right=row[r]^1;row[l]=right;row[r]=left;}return image;}
}
