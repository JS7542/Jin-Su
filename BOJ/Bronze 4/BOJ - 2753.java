import java.io.*;

class Main {
    /*
     * 연도가 4의 배수이면서 100의 배수가 아니거나, 400의 배수인지 확인한다.
     * 윤년이면 1, 아니면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine().trim());
        boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        System.out.print(leap ? 1 : 0);
    }
}
