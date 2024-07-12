import java.io.*; import java.math.*;
class Main {
    /*
     * 큰 정수 n과 m을 BigInteger로 읽는다.
     * 몫과 나머지를 divide와 remainder로 각각 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); BigInteger n=new BigInteger(br.readLine()),m=new BigInteger(br.readLine());
        System.out.print(n.divide(m)+"\n"+n.remainder(m));
    }
}
