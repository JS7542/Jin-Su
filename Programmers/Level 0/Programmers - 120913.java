import java.util.*;
class Solution {
    /*
     * 문자열을 n글자 간격으로 나누고 마지막 구간은 남은 길이만큼 자른다.
     * 각 substring을 리스트에 저장해 문자열 배열로 반환한다.
     */
    public String[] solution(String my_str,int n){List<String>l=new ArrayList<>();for(int i=0;i<my_str.length();i+=n)l.add(my_str.substring(i,Math.min(i+n,my_str.length())));return l.toArray(new String[0]);}
}
