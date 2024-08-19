class Solution {
    /*
     * 각 문자의 너비를 현재 줄에 더하고 100을 초과하면 새 줄에서 시작한다.
     * 사용한 줄 수와 마지막 줄의 너비를 배열로 반환한다.
     */
    public int[] numberOfLines(int[] widths,String s){int lines=1,width=0;for(char c:s.toCharArray()){int w=widths[c-'a'];if(width+w>100){lines++;width=w;}else width+=w;}return new int[]{lines,width};}
}
