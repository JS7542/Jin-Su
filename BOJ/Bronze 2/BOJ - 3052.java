import java.io.*;

class Main {
    /*
     * 열 개의 수를 42로 나눈 나머지를 boolean 배열에 표시한다.
     * 한 번이라도 등장한 나머지의 개수를 세어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] seen = new boolean[42];

        for (int i = 0; i < 10; i++) {
            seen[Integer.parseInt(br.readLine()) % 42] = true;
        }

        int answer = 0;
        for (boolean value : seen) if (value) answer++;
        System.out.print(answer);
    }
}
