import java.io.*;

class Main {
    /*
     * 입력받은 문자 한 개를 정수형으로 변환한다.
     * char 값 자체가 문자 코드이므로 형변환한 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print((int) br.readLine().charAt(0));
    }
}
