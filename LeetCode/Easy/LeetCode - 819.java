import java.util.*;
class Solution {
    /*
     * 문단을 소문자 단어로 분리하고 금지 단어를 제외해 빈도를 센다.
     * 가장 높은 빈도를 가진 단어를 반환한다.
     */
    public String mostCommonWord(String paragraph,String[] banned){Set<String>ban=new HashSet<>(Arrays.asList(banned));Map<String,Integer>m=new HashMap<>();String ans="";int best=0;for(String w:paragraph.toLowerCase().split("[^a-z]+"))if(!w.isEmpty()&&!ban.contains(w)){int c=m.getOrDefault(w,0)+1;m.put(w,c);if(c>best){best=c;ans=w;}}return ans;}
}
