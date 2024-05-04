class Solution {
    /*
     * 앞의 세 수로 등차수열인지 등비수열인지 판별한다.
     * 일정한 차 또는 비를 마지막 항에 적용해 다음 수를 반환한다.
     */
    public int solution(int[] common){int n=common.length;return common[1]-common[0]==common[2]-common[1]?common[n-1]+common[1]-common[0]:common[n-1]*(common[1]/common[0]);}
}
