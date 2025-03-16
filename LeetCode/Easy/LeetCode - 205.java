import java.util.*;
class Solution {
    /*
     * 두 문자열의 각 문자가 서로 일관되게 대응하는지 양방향 매핑으로 확인한다.
     * 한쪽이라도 기존 대응과 다르면 동형 문자열이 아니다.
     */
    public boolean isIsomorphic(String s,String t){Map<Character,Character>a=new HashMap<>(),b=new HashMap<>();for(int i=0;i<s.length();i++){char x=s.charAt(i),y=t.charAt(i);if(a.getOrDefault(x,y)!=y||b.getOrDefault(y,x)!=x)return false;a.put(x,y);b.put(y,x);}return true;}
}
