class Solution {
    /*
     * str1 안에 str2가 연속 부분 문자열로 포함되는지 contains로 확인한다.
     * 포함되면 1, 아니면 2를 반환한다.
     */
    public int solution(String str1,String str2){return str1.contains(str2)?1:2;}
}
