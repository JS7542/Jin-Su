import java.util.*;
class Solution {
    /*
     * numlist를 순회하며 n으로 나누어떨어지는 값만 선택한다.
     * 선택한 값을 입력 순서대로 정수 배열로 반환한다.
     */
    public int[] solution(int n,int[] numlist){return Arrays.stream(numlist).filter(x->x%n==0).toArray();}
}
