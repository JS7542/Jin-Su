import java.io.*; import java.util.*;
class Main {
    /*
     * 문제에서 정의한 연산 (A+B)(A-B)를 그대로 계산한다.
     * 입력 범위를 고려해 long 자료형으로 곱셈 결과를 저장한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long a=Long.parseLong(st.nextToken()),b=Long.parseLong(st.nextToken());
        System.out.print((a+b)*(a-b));
    }
}
