import java.io.*;

class Main {
    /*
     * 길이별로 0과 1로 끝나는 이친수 개수를 구분한다.
     * 0 뒤에는 0과 1이 가능하고, 1 뒤에는 0만 가능하다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long endZero = 0;
        long endOne = 1;

        for (int length = 2; length <= n; length++) {
            long nextZero = endZero + endOne;
            long nextOne = endZero;
            endZero = nextZero;
            endOne = nextOne;
        }

        System.out.print(endZero + endOne);
    }
}
