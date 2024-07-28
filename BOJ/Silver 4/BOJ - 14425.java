import java.io.*; import java.util.*;
class Main {
    /*
     * 집합 S의 문자열 N개를 HashSet에 저장한다.
     * 이후 M개의 문자열 중 집합에 포함된 문자열의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());Set<String>s=new HashSet<>();
        while(n-->0)s.add(br.readLine());int answer=0;while(m-->0)if(s.contains(br.readLine()))answer++;System.out.print(answer);
    }
}
