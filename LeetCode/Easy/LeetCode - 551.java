class Solution {
    /*
     * 결석 A의 총개수와 연속 지각 L의 길이를 순회하며 관리한다.
     * 결석이 두 번 이상이거나 지각이 세 번 연속이면 false다.
     */
    public boolean checkRecord(String s){int absent=0,late=0;for(char c:s.toCharArray()){if(c=='A')absent++;late=c=='L'?late+1:0;if(absent>=2||late>=3)return false;}return true;}
}
