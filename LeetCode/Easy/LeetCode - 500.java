import java.util.*;
class Solution {
    /*
     * 각 알파벳이 어느 키보드 행에 속하는지 배열로 표시한다.
     * 단어의 모든 문자가 첫 문자와 같은 행이면 결과에 추가한다.
     */
    public String[] findWords(String[] words){int[]row=new int[26];for(char c:"qwertyuiop".toCharArray())row[c-'a']=1;for(char c:"asdfghjkl".toCharArray())row[c-'a']=2;for(char c:"zxcvbnm".toCharArray())row[c-'a']=3;List<String>r=new ArrayList<>();for(String w:words){String x=w.toLowerCase();boolean ok=true;for(char c:x.toCharArray())if(row[c-'a']!=row[x.charAt(0)-'a'])ok=false;if(ok)r.add(w);}return r.toArray(new String[0]);}
}
