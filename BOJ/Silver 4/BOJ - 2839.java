import java.io.*;

class Main {
    /*
     * 5kg 봉지를 최대한 사용하되 나머지가 5로 나누어지지 않으면 3kg씩 줄인다.
     * 정확히 만들 수 있으면 봉지 수를, 끝까지 불가능하면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bags = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                bags += n / 5;
                System.out.print(bags);
                return;
            }
            n -= 3;
            bags++;
        }

        System.out.print(-1);
    }
}
