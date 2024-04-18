import java.io.*;

class Main {
    /*
     * END가 입력될 때까지 각 줄을 읽는다.
     * 문자열을 뒤집어 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("END")) {
            output.append(new StringBuilder(line).reverse()).append('\n');
        }

        System.out.print(output);
    }
}
