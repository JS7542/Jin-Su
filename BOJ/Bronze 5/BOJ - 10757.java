import java.io.*; import java.util.*; import java.math.*;
class Main {
    /*
     * 기본 정수 범위를 넘는 두 수를 BigInteger로 입력받는다.
     * add 메서드로 정확한 합을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        StringTokenizer st=new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken())));
    }
}
