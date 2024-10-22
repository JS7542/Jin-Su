import java.util.*;
class Solution {
    /*
     * 각 숫자의 가장 최근 인덱스를 해시맵에 저장한다.
     * 같은 숫자의 이전 위치와 현재 위치 차이가 k 이하이면 true를 반환한다.
     */
    public boolean containsNearbyDuplicate(int[] nums,int k){Map<Integer,Integer>m=new HashMap<>();for(int i=0;i<nums.length;i++){Integer p=m.put(nums[i],i);if(p!=null&&i-p<=k)return true;}return false;}
}
