import java.io.*; import java.util.*;
class Main {
    /*
     * ArrayDeque를 이용해 push, pop, size, empty, front, back 명령을 처리한다.
     * 결과가 필요한 명령만 StringBuilder에 저장해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());Deque<Integer>q=new ArrayDeque<>();StringBuilder sb=new StringBuilder();while(n-->0){String line=br.readLine();if(line.startsWith("push"))q.offer(Integer.parseInt(line.substring(5)));else if(line.equals("pop"))sb.append(q.isEmpty()?-1:q.poll());else if(line.equals("size"))sb.append(q.size());else if(line.equals("empty"))sb.append(q.isEmpty()?1:0);else if(line.equals("front"))sb.append(q.isEmpty()?-1:q.peekFirst());else sb.append(q.isEmpty()?-1:q.peekLast());if(!line.startsWith("push"))sb.append('\n');}System.out.print(sb);
    }
}
