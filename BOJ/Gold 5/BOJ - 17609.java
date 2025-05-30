import java.io.*;

class Main {
    /*
     * 양 끝 문자를 비교하다 처음 불일치한 위치에서 왼쪽 또는 오른쪽 문자를 하나 제외한다.
     * 그대로 회문이면 0, 한 문자 제외로 가능하면 1, 불가능하면 2를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            String text = br.readLine();
            int left = 0;
            int right = text.length() - 1;
            int result = 0;

            while (left < right && text.charAt(left) == text.charAt(right)) {
                left++;
                right--;
            }

            if (left < right) {
                boolean skipLeft = palindrome(text, left + 1, right);
                boolean skipRight = palindrome(text, left, right - 1);
                result = skipLeft || skipRight ? 1 : 2;
            }

            output.append(result).append('\n');
        }

        System.out.print(output);
    }

    private static boolean palindrome(String text, int left, int right) {
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }

        return true;
    }
}
