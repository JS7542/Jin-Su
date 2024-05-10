import java.io.*; import java.util.*;
class Main {
    /*
     * 첫 집합의 원소를 HashSet에 넣고 두 번째 집합을 순회한다.
     * 공통 원소는 제거하고 새로운 원소는 추가하면 마지막 크기가 대칭 차집합 크기다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer(br.readLine());int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());Set<Integer>s=new HashSet<>();st=new StringTokenizer(br.readLine());while(a-->0)s.add(Integer.parseInt(st.nextToken()));st=new StringTokenizer(br.readLine());while(b-->0){int x=Integer.parseInt(st.nextToken());if(!s.remove(x))s.add(x);}System.out.print(s.size());
    }
}
