import java.io.*;

class Main {
    /*
     * 세 수의 곱을 문자열로 바꾸고 각 숫자의 등장 횟수를 센다.
     * 0부터 9까지의 빈도수를 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine()) *
                    Integer.parseInt(br.readLine()) *
                    Integer.parseInt(br.readLine());

        int[] count = new int[10];
        for (char ch : String.valueOf(value).toCharArray()) count[ch - '0']++;

        StringBuilder sb = new StringBuilder();
        for (int c : count) sb.append(c).append('\n');
        System.out.print(sb);
    }
}
