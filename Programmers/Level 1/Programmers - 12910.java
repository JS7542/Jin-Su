import java.util.*;
class Solution {
    /*
     * arr에서 divisor로 나누어떨어지는 값만 선택해 오름차순 정렬한다.
     * 선택된 값이 없으면 {-1}을 반환한다.
     */
    public int[] solution(int[] arr,int divisor){int[]a=Arrays.stream(arr).filter(x->x%divisor==0).sorted().toArray();return a.length==0?new int[]{-1}:a;}
}
