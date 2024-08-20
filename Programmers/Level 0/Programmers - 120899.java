class Solution {
    /*
     * 배열을 한 번 순회하며 최댓값과 해당 인덱스를 함께 갱신한다.
     * 최댓값과 위치를 길이 2 배열로 반환한다.
     */
    public int[] solution(int[] array){int max=array[0],idx=0;for(int i=1;i<array.length;i++)if(array[i]>max){max=array[i];idx=i;}return new int[]{max,idx};}
}
