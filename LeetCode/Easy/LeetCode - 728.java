import java.util.*;
class Solution {
    /*
     * 범위의 각 숫자에 대해 모든 자릿수가 0이 아니며 원래 수를 나누는지 확인한다.
     * 조건을 만족하는 숫자를 오름차순 리스트에 추가한다.
     */
    public List<Integer> selfDividingNumbers(int left,int right){List<Integer>r=new ArrayList<>();for(int n=left;n<=right;n++){int x=n;boolean ok=true;while(x>0){int d=x%10;if(d==0||n%d!=0){ok=false;break;}x/=10;}if(ok)r.add(n);}return r;}
}
