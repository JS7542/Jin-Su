import java.io.*;

class Main {
    /*
     * 666부터 숫자를 하나씩 증가시키며 문자열에 666이 포함되는지 확인한다.
     * N번째로 조건을 만족한 숫자를 영화 제목 번호로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 665;

        while (count < n) {
            number++;
            if (String.valueOf(number).contains("666")) count++;
        }

        System.out.print(number);
    }
}
