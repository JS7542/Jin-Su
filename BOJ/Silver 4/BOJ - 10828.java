import java.io.*; import java.util.*;
class Main {
    /*
     * ArrayDeque를 스택으로 사용해 push, pop, size, empty, top 명령을 처리한다.
     * 값을 출력하는 명령의 결과만 모아서 한 번에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine());Deque<Integer>s=new ArrayDeque<>();StringBuilder sb=new StringBuilder();while(n-->0){String line=br.readLine();if(line.startsWith("push"))s.push(Integer.parseInt(line.substring(5)));else{if(line.equals("pop"))sb.append(s.isEmpty()?-1:s.pop());else if(line.equals("size"))sb.append(s.size());else if(line.equals("empty"))sb.append(s.isEmpty()?1:0);else sb.append(s.isEmpty()?-1:s.peek());sb.append('\n');}}System.out.print(sb);
    }
}
