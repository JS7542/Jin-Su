class Solution {
    /*
     * 두 문자열의 모든 문자를 XOR한다.
     * 공통 문자는 상쇄되고 t에 추가된 한 문자만 남는다.
     */
    public char findTheDifference(String s,String t){char x=0;for(char c:s.toCharArray())x^=c;for(char c:t.toCharArray())x^=c;return x;}
}
