import java.util.*;
class Solution {
    /*
     * 유효 점수를 스택에 저장하고 +, D, C 명령에 따라 새 점수 추가 또는 취소를 처리한다.
     * 마지막에 스택에 남은 모든 점수의 합을 반환한다.
     */
    public int calPoints(String[] operations){Deque<Integer>s=new ArrayDeque<>();for(String op:operations){if(op.equals("+")){int a=s.pop(),b=s.peek();s.push(a);s.push(a+b);}else if(op.equals("D"))s.push(s.peek()*2);else if(op.equals("C"))s.pop();else s.push(Integer.parseInt(op));}int ans=0;for(int x:s)ans+=x;return ans;}
}
