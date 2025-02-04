class Solution {
    /*
     * 두 숫자 문자열의 끝에서부터 각 자리와 올림을 더한다.
     * 낮은 자리부터 만든 결과를 뒤집어 최종 합 문자열을 반환한다.
     */
    public String addStrings(String num1,String num2){StringBuilder sb=new StringBuilder();int i=num1.length()-1,j=num2.length()-1,carry=0;while(i>=0||j>=0||carry>0){int s=carry+(i>=0?num1.charAt(i--)-'0':0)+(j>=0?num2.charAt(j--)-'0':0);sb.append(s%10);carry=s/10;}return sb.reverse().toString();}
}
