import java.io.*;

class Main {
    /*
     * #이 입력될 때까지 각 문장을 소문자로 변환한다.
     * a, e, i, o, u에 해당하는 문자의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("#")) {
            int count = 0;

            for (char ch : line.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(ch) >= 0) count++;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
