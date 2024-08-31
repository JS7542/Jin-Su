class Solution {
    /*
     * 단어 안의 위치를 따로 세어 짝수 번째 문자는 대문자, 홀수 번째는 소문자로 바꾼다.
     * 공백을 만나면 단어 위치를 0으로 초기화한다.
     */
    public String solution(String s){StringBuilder sb=new StringBuilder();int index=0;for(char c:s.toCharArray()){if(c==' '){sb.append(c);index=0;}else{sb.append(index++%2==0?Character.toUpperCase(c):Character.toLowerCase(c));}}return sb.toString();}
}
