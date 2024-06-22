import java.io.*; import java.util.*;
class Main {
    /*
     * 사이트 주소를 키, 비밀번호를 값으로 하는 해시맵을 만든다.
     * 각 질의 주소의 비밀번호를 O(1) 평균 시간으로 찾아 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());Map<String,String>map=new HashMap<>();while(n-->0){st=new StringTokenizer(br.readLine());map.put(st.nextToken(),st.nextToken());}StringBuilder sb=new StringBuilder();while(m-->0)sb.append(map.get(br.readLine())).append('\n');System.out.print(sb);
    }
}
