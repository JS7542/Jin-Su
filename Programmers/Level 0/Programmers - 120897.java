import java.util.*;
class Solution {
    /*
     * 1부터 n까지 순회하며 n을 나누어떨어지게 하는 수를 찾는다.
     * 약수를 오름차순 리스트에 저장한 뒤 정수 배열로 반환한다.
     */
    public int[] solution(int n){List<Integer>l=new ArrayList<>();for(int i=1;i<=n;i++)if(n%i==0)l.add(i);return l.stream().mapToInt(Integer::intValue).toArray();}
}
