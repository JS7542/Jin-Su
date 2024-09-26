import java.util.*;
class Solution {
    /*
     * 각 자리수 제곱합을 반복 계산하고 이미 나온 값을 HashSet으로 감지한다.
     * 값이 1이면 행복한 수이고 반복 상태가 생기면 아니다.
     */
    public boolean isHappy(int n){Set<Integer>s=new HashSet<>();while(n!=1&&s.add(n)){int next=0;while(n>0){int d=n%10;next+=d*d;n/=10;}n=next;}return n==1;}
}
