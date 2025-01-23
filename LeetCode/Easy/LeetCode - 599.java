import java.util.*;
class Solution {
    /*
     * 첫 목록의 문자열별 인덱스를 해시맵에 저장한다.
     * 두 번째 목록을 순회하며 공통 문자열의 인덱스 합 최솟값을 유지한다.
     */
    public String[] findRestaurant(String[] list1,String[] list2){Map<String,Integer>m=new HashMap<>();for(int i=0;i<list1.length;i++)m.put(list1[i],i);List<String>r=new ArrayList<>();int best=Integer.MAX_VALUE;for(int j=0;j<list2.length;j++)if(m.containsKey(list2[j])){int sum=m.get(list2[j])+j;if(sum<best){best=sum;r.clear();}if(sum==best)r.add(list2[j]);}return r.toArray(new String[0]);}
}
