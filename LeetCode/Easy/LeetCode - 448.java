import java.util.*;
class Solution {
    /*
     * 각 값이 가리키는 인덱스의 숫자를 음수로 바꾸어 등장 여부를 표시한다.
     * 마지막에 양수로 남은 위치의 번호가 사라진 숫자다.
     */
    public List<Integer> findDisappearedNumbers(int[] nums){for(int x:nums){int i=Math.abs(x)-1;nums[i]=-Math.abs(nums[i]);}List<Integer>r=new ArrayList<>();for(int i=0;i<nums.length;i++)if(nums[i]>0)r.add(i+1);return r;}
}
