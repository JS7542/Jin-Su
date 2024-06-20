class Solution {
    /*
     * zero부터 nine까지의 영단어를 대응하는 숫자 문자로 치환한다.
     * 모든 치환이 끝난 문자열을 long으로 변환한다.
     */
    public long solution(String numbers){String[]w={"zero","one","two","three","four","five","six","seven","eight","nine"};for(int i=0;i<10;i++)numbers=numbers.replace(w[i],String.valueOf(i));return Long.parseLong(numbers);}
}
