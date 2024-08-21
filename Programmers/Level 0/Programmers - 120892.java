class Solution {
    /*
     * code번째 문자부터 code 간격으로 문자를 선택한다.
     * 1부터 시작하는 위치를 배열 인덱스에 맞게 code-1로 변환한다.
     */
    public String solution(String cipher,int code){StringBuilder sb=new StringBuilder();for(int i=code-1;i<cipher.length();i+=code)sb.append(cipher.charAt(i));return sb.toString();}
}
