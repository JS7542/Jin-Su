import java.io.*;

class Main {
    /*
     * 공백 없이 이어진 숫자 문자열을 한 문자씩 순회한다.
     * 각 문자에서 '0'을 빼 정수로 변환하고 합을 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String numbers = br.readLine();

        int sum = 0;
        for (char ch : numbers.toCharArray()) sum += ch - '0';
        System.out.print(sum);
    }
}
