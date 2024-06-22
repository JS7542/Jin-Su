import java.io.*; import java.util.*;
class Main {
    /*
     * 1부터 N까지 카드를 큐에 넣고 맨 앞 카드를 버린 뒤 다음 카드를 뒤로 옮긴다.
     * 큐에 카드 한 장만 남을 때까지 반복한다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());Deque<Integer>q=new ArrayDeque<>();for(int i=1;i<=n;i++)q.offer(i);while(q.size()>1){q.poll();q.offer(q.poll());}System.out.print(q.peek());
    }
}
