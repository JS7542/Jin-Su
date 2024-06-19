import java.io.*;

class Main {
    /*
     * 입력받은 닉네임을 가운데 줄의 팬 문자열 사이에 배치한다.
     * 위아래 줄은 고정된 팬 문자열을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nickname = br.readLine();

        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" + nickname + "::fan:");
        System.out.print(":fan::fan::fan:");
    }
}
