import java.util.*;
class Solution {
    /*
     * 각 숫자의 빈도를 해시맵에 저장한다.
     * x와 x+1이 모두 존재하는 경우 두 빈도 합의 최댓값을 구한다.
     */
    public int findLHS(int[] nums){Map<Integer,Integer>m=new HashMap<>();for(int x:nums)m.put(x,m.getOrDefault(x,0)+1);int ans=0;for(int x:m.keySet())if(m.containsKey(x+1))ans=Math.max(ans,m.get(x)+m.get(x+1));return ans;}
}
