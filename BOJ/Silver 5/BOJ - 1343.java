import java.io.*;

class Main {
    /*
     * 연속된 X 구간을 길이 4의 AAAA부터 채우고 남은 길이 2는 BB로 채운다.
     * 홀수 길이 X 구간이 있으면 덮을 수 없으므로 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        String replaced = board.replace("XXXX", "AAAA").replace("XX", "BB");

        System.out.print(replaced.contains("X") ? -1 : replaced);
    }
}
