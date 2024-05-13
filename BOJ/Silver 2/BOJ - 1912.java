import java.io.*; import java.util.*;
class Main {
    /*
     * 현재 위치에서 끝나는 최대 연속합은 이전 합을 이어갈지 현재 값부터 시작할지 선택한다.
     * 각 위치의 현재합 중 최댓값을 전체 답으로 유지한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());StringTokenizer st=new StringTokenizer(br.readLine());int current=Integer.parseInt(st.nextToken()),answer=current;for(int i=1;i<n;i++){int x=Integer.parseInt(st.nextToken());current=Math.max(x,current+x);answer=Math.max(answer,current);}System.out.print(answer);
    }
}
