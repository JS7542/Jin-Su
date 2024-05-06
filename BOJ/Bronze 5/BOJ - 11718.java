import java.io.*;

class Main {
    /*
     * 표준 입력에서 더 읽을 줄이 없을 때까지 모든 줄을 읽는다.
     * 입력된 내용을 줄바꿈을 포함해 그대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) sb.append(line).append('\n');
        System.out.print(sb);
    }
}
