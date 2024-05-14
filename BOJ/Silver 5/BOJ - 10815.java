import java.io.*; import java.util.*;
class Main {
    /*
     * 상근이가 가진 카드 숫자를 HashSet에 저장한다.
     * 질의 숫자가 집합에 존재하는지에 따라 1 또는 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());Set<Integer>s=new HashSet<>();StringTokenizer st=new StringTokenizer(br.readLine());while(n-->0)s.add(Integer.parseInt(st.nextToken()));
        int m=Integer.parseInt(br.readLine());st=new StringTokenizer(br.readLine());StringBuilder sb=new StringBuilder();while(m-->0)sb.append(s.contains(Integer.parseInt(st.nextToken()))?1:0).append(' ');System.out.print(sb);
    }
}
