import java.io.*;

class Main {
    /*
     * 한 번에 1개 또는 3개를 가져가며 마지막 돌을 가져간 사람이 진다.
     * 전체 돌 개수가 짝수면 선공, 홀수면 후공이 승리한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(n % 2 == 0 ? "SK" : "CY");
    }
}
