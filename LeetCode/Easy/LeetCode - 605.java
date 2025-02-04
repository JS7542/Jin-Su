class Solution {
    /*
     * 각 빈 화단에서 왼쪽과 오른쪽도 비어 있는지 확인한다.
     * 심을 수 있으면 현재 칸을 1로 바꾸고 필요한 꽃 수를 감소시킨다.
     */
    public boolean canPlaceFlowers(int[] flowerbed,int n){for(int i=0;i<flowerbed.length&&n>0;i++)if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){flowerbed[i]=1;n--;}return n==0;}
}
