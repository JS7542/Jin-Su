import java.io.*;

class Main {
    /*
     * 직사각형의 두 변의 길이를 각각 입력받는다.
     * 넓이는 두 변의 곱이므로 곱한 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.print(a * b);
    }
}
