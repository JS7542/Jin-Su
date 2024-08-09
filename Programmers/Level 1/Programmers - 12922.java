class Solution {
    /*
     * 짝수 인덱스에는 수, 홀수 인덱스에는 박을 배치한다.
     * n글자가 될 때까지 두 문자를 번갈아 이어 붙인다.
     */
    public String solution(int n){StringBuilder sb=new StringBuilder();for(int i=0;i<n;i++)sb.append(i%2==0?'수':'박');return sb.toString();}
}
