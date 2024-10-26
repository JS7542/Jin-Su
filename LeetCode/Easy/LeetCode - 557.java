class Solution {
    /*
     * 문자열을 공백 기준 단어로 나눈다.
     * 각 단어의 문자 순서만 뒤집고 단어 순서는 유지한다.
     */
    public String reverseWords(String s){String[]w=s.split(" ");StringBuilder out=new StringBuilder();for(int i=0;i<w.length;i++){if(i>0)out.append(' ');out.append(new StringBuilder(w[i]).reverse());}return out.toString();}
}
