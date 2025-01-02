class Solution {
    /*
     * 2k 길이 블록마다 앞쪽 k개 문자의 순서를 뒤집는다.
     * 마지막 블록은 남은 길이에 맞춰 뒤집을 끝 위치를 제한한다.
     */
    public String reverseStr(String s,int k){char[]a=s.toCharArray();for(int start=0;start<a.length;start+=2*k){int l=start,r=Math.min(start+k-1,a.length-1);while(l<r){char t=a[l];a[l++]=a[r];a[r--]=t;}}return new String(a);}
}
