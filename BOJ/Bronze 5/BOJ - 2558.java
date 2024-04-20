import java.io.*;
class Main {
    /*
     * 서로 다른 두 줄에서 정수 A와 B를 입력받는다.
     * 두 값을 더한 결과를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine()));
    }
}
