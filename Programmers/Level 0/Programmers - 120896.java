class Solution {
    /*
     * 각 소문자의 등장 횟수를 세고 빈도가 1인 문자만 선택한다.
     * 알파벳 순서로 배열을 순회해 자동으로 사전순 결과를 만든다.
     */
    public String solution(String s){int[]c=new int[26];for(char x:s.toCharArray())c[x-'a']++;StringBuilder sb=new StringBuilder();for(int i=0;i<26;i++)if(c[i]==1)sb.append((char)('a'+i));return sb.toString();}
}
