import java.io.*;

class Main {
    /*
     * 문자를 스택에 추가하고 마지막 네 문자가 PPAP가 될 때마다 P 하나로 축약한다.
     * 모든 축약 후 문자열이 P 하나만 남으면 올바른 PPAP 문자열이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        StringBuilder stack = new StringBuilder();

        for (char ch : text.toCharArray()) {
            stack.append(ch);

            int length = stack.length();

            if (length >= 4
                    && stack.charAt(length - 4) == 'P'
                    && stack.charAt(length - 3) == 'P'
                    && stack.charAt(length - 2) == 'A'
                    && stack.charAt(length - 1) == 'P') {
                stack.setLength(length - 3);
            }
        }

        System.out.print(stack.toString().equals("P") ? "PPAP" : "NP");
    }
}
