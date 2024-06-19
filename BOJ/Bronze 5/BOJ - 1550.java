import java.io.*;
class Main {
    /*
     * 입력 문자열을 기수 16으로 해석한다.
     * Integer.parseInt의 radix 인자를 사용해 십진수로 변환한다.
     */
    public static void main(String[] args) throws Exception {
        System.out.print(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine(),16));
    }
}
