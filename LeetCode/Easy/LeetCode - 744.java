class Solution {
    /*
     * target보다 큰 첫 문자를 찾도록 이분 탐색한다.
     * 모든 문자가 target 이하이면 순환 조건에 따라 첫 문자를 반환한다.
     */
    public char nextGreatestLetter(char[] letters,char target){int l=0,r=letters.length;while(l<r){int m=(l+r)/2;if(letters[m]<=target)l=m+1;else r=m;}return letters[l%letters.length];}
}
