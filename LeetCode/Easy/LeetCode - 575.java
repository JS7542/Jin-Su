import java.util.*;
class Solution {
    /*
     * 사탕 종류의 수를 HashSet으로 구한다.
     * 먹을 수 있는 사탕 개수 n/2와 종류 수 중 작은 값이 최대 종류 수다.
     */
    public int distributeCandies(int[] candyType){Set<Integer>s=new HashSet<>();for(int x:candyType)s.add(x);return Math.min(s.size(),candyType.length/2);}
}
