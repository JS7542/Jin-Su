import java.io.*;

class Main {
    /*
     * 완성형 한글은 가부터 유니코드 순서대로 연속 배치되어 있다.
     * 가의 코드에 N-1을 더한 문자를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print((char) ('가' + n - 1));
    }
}
