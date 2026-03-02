import java.io.*;

class Main {
    /*
     * 결과 문자열을 스택처럼 사용해 문자를 차례대로 추가한다.
     * 마지막 부분이 폭발 문자열과 같아지면 해당 길이만큼 즉시 제거한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String bomb = br.readLine();

        StringBuilder stack = new StringBuilder();

        for (char ch : text.toCharArray()) {
            stack.append(ch);

            if (stack.length() < bomb.length()) continue;
            if (stack.charAt(stack.length() - 1) != bomb.charAt(bomb.length() - 1)) continue;

            boolean matches = true;
            int start = stack.length() - bomb.length();

            for (int i = 0; i < bomb.length(); i++) {
                if (stack.charAt(start + i) != bomb.charAt(i)) {
                    matches = false;
                    break;
                }
            }

            if (matches) stack.setLength(start);
        }

        System.out.print(stack.length() == 0 ? "FRULA" : stack);
    }
}
