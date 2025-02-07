import java.util.*;
class Solution {
    /*
     * 보석 문자를 집합에 저장한다.
     * stones의 각 문자가 보석 집합에 포함되는 횟수를 센다.
     */
    public int numJewelsInStones(String jewels,String stones){Set<Character>s=new HashSet<>();for(char c:jewels.toCharArray())s.add(c);int ans=0;for(char c:stones.toCharArray())if(s.contains(c))ans++;return ans;}
}
