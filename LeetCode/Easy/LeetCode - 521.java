class Solution {
    /*
     * 두 문자열이 같으면 어느 한쪽도 상대의 uncommon subsequence가 될 수 없다.
     * 다르면 더 긴 문자열 전체가 가장 긴 uncommon subsequence다.
     */
    public int findLUSlength(String a,String b){return a.equals(b)?-1:Math.max(a.length(),b.length());}
}
