import java.io.*; import java.util.*;
class Main {
    /*
     * 정상 체스 세트의 말 개수와 현재 개수를 위치별로 비교한다.
     * 각 말에 대해 필요한 추가 개수인 기준값-현재값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        int[] target={1,1,2,2,2,8}; StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()); StringBuilder sb=new StringBuilder();
        for(int i=0;i<6;i++) sb.append(target[i]-Integer.parseInt(st.nextToken())).append(' ');
        System.out.print(sb);
    }
}
