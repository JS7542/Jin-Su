import java.io.*;

class Main {
    /*
     * 첫 번째 옷은 N가지 중 하나를 고른다.
     * 두 번째 옷은 첫 번째와 달라야 하므로 N-1가지를 고를 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(n * (n - 1));
    }
}
