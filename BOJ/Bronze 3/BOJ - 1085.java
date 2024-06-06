import java.io.*; import java.util.*;
class Main {
    /*
     * 현재 점에서 네 변까지의 거리는 x, y, w-x, h-y이다.
     * 네 거리 중 최솟값이 직사각형 경계까지의 최소 거리다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken()),w=Integer.parseInt(st.nextToken()),h=Integer.parseInt(st.nextToken());
        System.out.print(Math.min(Math.min(x,w-x),Math.min(y,h-y)));
    }
}
