class Solution {
    /*
     * 문자열의 각 문자가 대문자인지 소문자인지 확인한다.
     * 대문자는 소문자로, 소문자는 대문자로 바꾸어 결과를 만든다.
     */
    public String solution(String my_string){StringBuilder sb=new StringBuilder();for(char c:my_string.toCharArray())sb.append(Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c));return sb.toString();}
}
