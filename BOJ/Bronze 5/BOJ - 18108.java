import java.io.*;

class Main {
    /*
     * 불기 연도와 서기 연도의 차이는 543년이다.
     * 입력 연도에서 543을 빼 서기 연도를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine()) - 543);
    }
}
