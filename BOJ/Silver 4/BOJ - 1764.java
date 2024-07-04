import java.io.*; import java.util.*;
class Main {
    /*
     * 듣지 못한 사람을 집합에 저장하고 보지 못한 사람 중 공통 이름을 찾는다.
     * 결과 이름을 사전순으로 정렬해 개수와 함께 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());Set<String>s=new HashSet<>();while(n-->0)s.add(br.readLine());List<String>list=new ArrayList<>();while(m-->0){String x=br.readLine();if(s.contains(x))list.add(x);}Collections.sort(list);StringBuilder sb=new StringBuilder().append(list.size()).append('\n');for(String x:list)sb.append(x).append('\n');System.out.print(sb);
    }
}
