import java.io.*;

class Main {
    static String compressed;
    static int index;

    /*
     * 괄호 안 문자열 길이를 재귀적으로 계산한다.
     * 숫자 K 뒤에 괄호가 오면 내부 길이에 K를 곱하고 일반 문자는 길이 1로 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        compressed = br.readLine();

        System.out.print(length());
    }

    static int length() {
        int result = 0;

        while (index < compressed.length()) {
            char current = compressed.charAt(index);

            if (current == ')') {
                index++;
                return result;
            }

            if (index + 1 < compressed.length()
                    && Character.isDigit(current)
                    && compressed.charAt(index + 1) == '(') {
                int multiplier = current - '0';
                index += 2;
                result += multiplier * length();
            } else {
                result++;
                index++;
            }
        }

        return result;
    }
}
