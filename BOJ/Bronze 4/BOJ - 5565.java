import java.io.*;

class Main {
    /*
     * 총 금액에서 알고 있는 아홉 권의 책 가격을 차례대로 뺀다.
     * 마지막에 남은 값이 가격을 잃어버린 책의 가격이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remaining = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) remaining -= Integer.parseInt(br.readLine());

        System.out.print(remaining);
    }
}
