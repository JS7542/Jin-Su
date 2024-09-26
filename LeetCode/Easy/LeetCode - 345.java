class Solution {
    /*
     * 양 끝 포인터가 각각 모음을 만날 때까지 이동한다.
     * 두 모음을 교환하며 가운데까지 진행해 모음 순서만 뒤집는다.
     */
    public String reverseVowels(String s){char[]a=s.toCharArray();int l=0,r=a.length-1;while(l<r){while(l<r&&!v(a[l]))l++;while(l<r&&!v(a[r]))r--;char t=a[l];a[l++]=a[r];a[r--]=t;}return new String(a);}private boolean v(char c){return "aeiouAEIOU".indexOf(c)>=0;}
}
