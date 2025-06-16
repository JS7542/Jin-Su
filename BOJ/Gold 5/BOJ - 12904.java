import java.io.*;

class Main {
    /*
     * 목표 문자열에서 원본 문자열 길이까지 역연산한다.
     * 마지막 문자가 A면 제거하고, B면 제거한 뒤 문자열 방향을 뒤집는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        StringBuilder target = new StringBuilder(br.readLine());
        boolean reversed = false;

        while (target.length() > source.length()) {
            char removed;

            if (!reversed) {
                removed = target.charAt(target.length() - 1);
                target.deleteCharAt(target.length() - 1);
            } else {
                removed = target.charAt(0);
                target.deleteCharAt(0);
            }

            if (removed == 'B') reversed = !reversed;
        }

        String result = reversed ? target.reverse().toString() : target.toString();
        System.out.print(result.equals(source) ? 1 : 0);
    }
}
