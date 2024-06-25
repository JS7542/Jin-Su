import java.util.*;
class Solution {
    /*
     * 각 문자열의 문자를 정렬해 애너그램 그룹을 식별하는 키로 사용한다.
     * 같은 키를 가진 문자열을 해시맵의 같은 리스트에 모아 반환한다.
     */
    public List<List<String>> groupAnagrams(String[] strs){Map<String,List<String>>m=new HashMap<>();for(String s:strs){char[]a=s.toCharArray();Arrays.sort(a);m.computeIfAbsent(new String(a),k->new ArrayList<>()).add(s);}return new ArrayList<>(m.values());}
}
