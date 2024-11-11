import java.util.*;
class Solution {
    /*
     * 연속 구간의 시작점을 잡고 다음 값이 1씩 증가하는 동안 끝점을 확장한다.
     * 길이에 따라 단일 숫자 또는 start->end 형식으로 저장한다.
     */
    public List<String> summaryRanges(int[] nums){List<String>r=new ArrayList<>();for(int i=0;i<nums.length;){int j=i;while(j+1<nums.length&&(long)nums[j]+1==nums[j+1])j++;r.add(i==j?String.valueOf(nums[i]):nums[i]+"->"+nums[j]);i=j+1;}return r;}
}
