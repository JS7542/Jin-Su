import java.util.*;
class Solution {
    /*
     * 패턴 문자와 단어 사이의 대응을 양방향 해시맵으로 관리한다.
     * 토큰 수가 다르거나 기존 대응이 충돌하면 false를 반환한다.
     */
    public boolean wordPattern(String pattern,String s){String[]w=s.split(" ");if(w.length!=pattern.length())return false;Map<Character,String>a=new HashMap<>();Map<String,Character>b=new HashMap<>();for(int i=0;i<w.length;i++){char c=pattern.charAt(i);if(a.containsKey(c)&&!a.get(c).equals(w[i])||b.containsKey(w[i])&&b.get(w[i])!=c)return false;a.put(c,w[i]);b.put(w[i],c);}return true;}
}
