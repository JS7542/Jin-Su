class Solution {
    /*
     * 서로 다른 상위 세 값을 Long 객체로 유지한다.
     * 중복을 건너뛰고 세 번째 값이 없으면 최댓값을 반환한다.
     */
    public int thirdMax(int[] nums){Long a=null,b=null,c=null;for(int x:nums){long v=x;if(a!=null&&v==a||b!=null&&v==b||c!=null&&v==c)continue;if(a==null||v>a){c=b;b=a;a=v;}else if(b==null||v>b){c=b;b=v;}else if(c==null||v>c)c=v;}return (int)(c==null?a:c).longValue();}
}
