import java.io.*; import java.util.*;
class Main {
    /*
     * 다섯 숫자의 제곱을 모두 더한다.
     * 합을 10으로 나눈 나머지를 검증수로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int sum=0;
        while(st.hasMoreTokens()){ int x=Integer.parseInt(st.nextToken()); sum+=x*x; }
        System.out.print(sum%10);
    }
}
