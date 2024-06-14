import java.io.*;

class Main {
    /*
     * 문자열과 1부터 시작하는 위치 i를 입력받는다.
     * 자바 인덱스는 0부터 시작하므로 i-1 위치의 문자를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int index = Integer.parseInt(br.readLine());
        System.out.print(text.charAt(index - 1));
    }
}
