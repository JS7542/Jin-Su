class Solution {
    /*
     * magazine의 각 소문자 빈도를 센다.
     * ransomNote의 문자를 사용할 때 빈도를 감소시키며 부족하면 false를 반환한다.
     */
    public boolean canConstruct(String ransomNote,String magazine){int[]c=new int[26];for(char x:magazine.toCharArray())c[x-'a']++;for(char x:ransomNote.toCharArray())if(--c[x-'a']<0)return false;return true;}
}
