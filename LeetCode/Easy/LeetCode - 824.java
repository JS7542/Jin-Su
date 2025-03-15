class Solution {
    /*
     * 모음으로 시작하면 단어를 유지하고 자음이면 첫 문자를 뒤로 이동한다.
     * ma와 단어 순서만큼의 a를 붙여 새 문장을 만든다.
     */
    public String toGoatLatin(String sentence){String[]w=sentence.split(" ");StringBuilder out=new StringBuilder(),tail=new StringBuilder("a");for(int i=0;i<w.length;i++){String x=w[i];if("aeiouAEIOU".indexOf(x.charAt(0))<0)x=x.substring(1)+x.charAt(0);if(i>0)out.append(' ');out.append(x).append("ma").append(tail);tail.append('a');}return out.toString();}
}
