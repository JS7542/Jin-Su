import java.util.*;
class Solution {
    /*
     * 아이 욕심과 쿠키 크기를 각각 오름차순 정렬한다.
     * 현재 아이를 만족시키는 가장 작은 쿠키를 두 포인터로 배정한다.
     */
    public int findContentChildren(int[] g,int[] s){Arrays.sort(g);Arrays.sort(s);int i=0,j=0;while(i<g.length&&j<s.length){if(s[j]>=g[i])i++;j++;}return i;}
}
