class Solution {
    /*
     * 첫 순회에서 각 알파벳의 빈도를 계산한다.
     * 두 번째 순회에서 빈도가 1인 첫 인덱스를 반환한다.
     */
    public int firstUniqChar(String s){int[]c=new int[26];for(char x:s.toCharArray())c[x-'a']++;for(int i=0;i<s.length();i++)if(c[s.charAt(i)-'a']==1)return i;return -1;}
}
