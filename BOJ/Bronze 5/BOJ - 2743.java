import java.io.*;

class Main {
    /*
     * 입력받은 단어의 문자열 길이를 구한다.
     * String.length() 결과를 그대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(br.readLine().length());
    }
}
