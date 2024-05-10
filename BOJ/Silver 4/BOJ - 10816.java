import java.io.*; import java.util.*;
class Main {
    /*
     * 각 카드 숫자의 등장 횟수를 해시맵에 저장한다.
     * 질의 숫자마다 저장된 빈도수를 없으면 0으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());Map<Integer,Integer>map=new HashMap<>();StringTokenizer st=new StringTokenizer(br.readLine());while(n-->0){int x=Integer.parseInt(st.nextToken());map.put(x,map.getOrDefault(x,0)+1);}int m=Integer.parseInt(br.readLine());st=new StringTokenizer(br.readLine());StringBuilder sb=new StringBuilder();while(m-->0)sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()),0)).append(' ');System.out.print(sb);
    }
}
