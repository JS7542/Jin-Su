import java.io.*;

class Main {
    /*
     * 두 이진 문자열을 10진 정수로 변환해 곱한다.
     * 곱셈 결과를 다시 이진 문자열로 바꾸어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine(), 2);
        int second = Integer.parseInt(br.readLine(), 2);

        System.out.print(Integer.toBinaryString(first * second));
    }
}
