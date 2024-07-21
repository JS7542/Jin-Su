class Solution {
    /*
     * 가능한 발음 aya, ye, woo, ma를 빈 문자열로 치환한다.
     * 모든 문자가 제거된 단어의 개수를 센다.
     */
    public int solution(String[] babbling){int answer=0;for(String s:babbling){String t=s;for(String w:new String[]{"aya","ye","woo","ma"})t=t.replace(w," ");if(t.trim().isEmpty())answer++;}return answer;}
}
