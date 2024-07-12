import java.io.*;

class Main {
    /*
     * 입력 n에 대해 첫 번째 값은 2×(n+1)이다.
     * 두 번째 값은 3×(n+1)이며 두 값을 공백으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(2 * (n + 1) + " " + 3 * (n + 1));
    }
}
