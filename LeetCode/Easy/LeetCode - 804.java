import java.util.*;
class Solution {
    /*
     * 각 알파벳을 모스부호 배열로 변환해 단어별 변환 문자열을 만든다.
     * 변환 결과를 HashSet에 저장해 서로 다른 표현의 개수를 반환한다.
     */
    public int uniqueMorseRepresentations(String[] words){String[]m={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};Set<String>s=new HashSet<>();for(String w:words){StringBuilder b=new StringBuilder();for(char c:w.toCharArray())b.append(m[c-'a']);s.add(b.toString());}return s.size();}
}
