class Solution {
    /*
     * 문자열을 문자 배열로 바꾸고 num1과 num2 위치의 값을 교환한다.
     * 교환된 배열을 다시 문자열로 변환해 반환한다.
     */
    public String solution(String my_string,int num1,int num2){char[]a=my_string.toCharArray();char t=a[num1];a[num1]=a[num2];a[num2]=t;return new String(a);}
}
