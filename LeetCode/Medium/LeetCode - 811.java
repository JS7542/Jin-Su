import java.util.*;
class Solution {
    /*
     * 각 도메인의 방문 수를 읽고 점 위치마다 잘라 모든 상위 도메인에 누적한다.
     * 해시맵의 도메인별 누적 횟수를 출력 문자열 리스트로 변환한다.
     */
    public List<String> subdomainVisits(String[] cpdomains){Map<String,Integer>m=new HashMap<>();for(String x:cpdomains){String[]p=x.split(" ");int count=Integer.parseInt(p[0]);String d=p[1];while(true){m.put(d,m.getOrDefault(d,0)+count);int i=d.indexOf('.');if(i<0)break;d=d.substring(i+1);}}List<String>r=new ArrayList<>();for(String d:m.keySet())r.add(m.get(d)+" "+d);return r;}
}
