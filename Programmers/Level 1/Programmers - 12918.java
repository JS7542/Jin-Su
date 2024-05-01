class Solution {
    /*
     * 문자열 길이가 4 또는 6인지 확인하고 모든 문자가 숫자인지 검사한다.
     * 두 조건을 모두 만족할 때만 true를 반환한다.
     */
    public boolean solution(String s){if(s.length()!=4&&s.length()!=6)return false;for(char c:s.toCharArray())if(!Character.isDigit(c))return false;return true;}
}
