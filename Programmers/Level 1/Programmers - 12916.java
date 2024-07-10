class Solution {
    /*
     * 문자열을 소문자로 통일하고 p와 y의 개수를 각각 센다.
     * 두 개수가 같으면 true를 반환한다.
     */
    public boolean solution(String s){int count=0;for(char c:s.toLowerCase().toCharArray())if(c=='p')count++;else if(c=='y')count--;return count==0;}
}
