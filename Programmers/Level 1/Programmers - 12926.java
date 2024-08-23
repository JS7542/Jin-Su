class Solution {
    /*
     * 알파벳 문자는 대소문자 시작점을 기준으로 n만큼 순환 이동한다.
     * 공백은 그대로 유지해 암호화된 문자열을 만든다.
     */
    public String solution(String s,int n){StringBuilder sb=new StringBuilder();for(char c:s.toCharArray()){if(c==' ')sb.append(c);else{char base=Character.isUpperCase(c)?'A':'a';sb.append((char)(base+(c-base+n)%26));}}return sb.toString();}
}
