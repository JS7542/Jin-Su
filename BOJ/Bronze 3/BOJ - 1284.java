import java.io.*;

class Main {
    /*
     * 숫자별 필요한 너비와 숫자 사이 공백을 합산한다.
     * 0이 입력될 때까지 각 주소판의 전체 너비를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String number;

        while (!(number = br.readLine()).equals("0")) {
            int width = number.length() + 1;

            for (char digit : number.toCharArray()) {
                if (digit == '1') width += 2;
                else if (digit == '0') width += 4;
                else width += 3;
            }

            sb.append(width).append('\n');
        }

        System.out.print(sb);
    }
}
