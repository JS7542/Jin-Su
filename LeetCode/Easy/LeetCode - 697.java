import java.util.*;
class Solution {
    /*
     * 각 숫자의 빈도와 첫·마지막 인덱스를 저장한다.
     * 배열 차수와 같은 빈도를 가진 숫자 중 구간 길이가 가장 짧은 값을 찾는다.
     */
    public int findShortestSubArray(int[] nums){Map<Integer,Integer>count=new HashMap<>(),first=new HashMap<>();int degree=0,ans=nums.length;for(int i=0;i<nums.length;i++){first.putIfAbsent(nums[i],i);int c=count.getOrDefault(nums[i],0)+1;count.put(nums[i],c);if(c>degree){degree=c;ans=i-first.get(nums[i])+1;}else if(c==degree)ans=Math.min(ans,i-first.get(nums[i])+1);}return ans;}
}
