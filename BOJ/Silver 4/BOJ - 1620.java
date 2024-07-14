import java.io.*; import java.util.*;
class Main {
    /*
     * 번호에서 이름으로 찾는 배열과 이름에서 번호로 찾는 해시맵을 함께 만든다.
     * 질의 형태가 숫자인지 문자열인지 판단해 적절한 자료구조에서 답을 찾는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());String[]name=new String[n+1];Map<String,Integer>map=new HashMap<>();for(int i=1;i<=n;i++){name[i]=br.readLine();map.put(name[i],i);}StringBuilder sb=new StringBuilder();while(m-->0){String q=br.readLine();if(Character.isDigit(q.charAt(0)))sb.append(name[Integer.parseInt(q)]);else sb.append(map.get(q));sb.append('\n');}System.out.print(sb);
    }
}
