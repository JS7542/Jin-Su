class Solution {
    /*
     * 하이픈을 제거하고 뒤에서부터 K개마다 하이픈을 삽입한다.
     * 대문자로 바꾼 역순 결과를 마지막에 뒤집는다.
     */
    public String licenseKeyFormatting(String s,int k){StringBuilder sb=new StringBuilder();int count=0;for(int i=s.length()-1;i>=0;i--){char c=s.charAt(i);if(c=='-')continue;if(count==k){sb.append('-');count=0;}sb.append(Character.toUpperCase(c));count++;}return sb.reverse().toString();}
}
