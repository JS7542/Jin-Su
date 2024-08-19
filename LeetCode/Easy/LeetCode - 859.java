class Solution {
    /*
     * 문자열이 같으면 중복 문자가 있어 두 같은 문자를 교환할 수 있는지 확인한다.
     * 다르면 서로 다른 위치가 정확히 두 개이며 교차 문자가 같은지 검사한다.
     */
    public boolean buddyStrings(String s,String goal){if(s.length()!=goal.length())return false;if(s.equals(goal)){int[]c=new int[26];for(char x:s.toCharArray())if(++c[x-'a']>1)return true;return false;}int first=-1,second=-1;for(int i=0;i<s.length();i++)if(s.charAt(i)!=goal.charAt(i)){if(first<0)first=i;else if(second<0)second=i;else return false;}return second>=0&&s.charAt(first)==goal.charAt(second)&&s.charAt(second)==goal.charAt(first);}
}
