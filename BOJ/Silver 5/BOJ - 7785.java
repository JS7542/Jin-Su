import java.io.*; import java.util.*;
class Main {
    /*
     * enter이면 이름을 집합에 추가하고 leave이면 제거한다.
     * 남아 있는 이름을 역사전순 TreeSet에 저장해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());Set<String>s=new TreeSet<>(Collections.reverseOrder());
        while(n-->0){StringTokenizer st=new StringTokenizer(br.readLine());String name=st.nextToken(),state=st.nextToken();if(state.equals("enter"))s.add(name);else s.remove(name);}StringBuilder sb=new StringBuilder();for(String x:s)sb.append(x).append('\n');System.out.print(sb);
    }
}
