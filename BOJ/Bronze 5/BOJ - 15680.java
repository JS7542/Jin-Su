import java.io.*;

class Main {
    /*
     * 입력값이 0이면 학교 이름을 출력한다.
     * 입력값이 1이면 학교의 슬로건을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());

        System.out.print(value == 0
                ? "YONSEI"
                : "Leading the Way to the Future");
    }
}
