import java.io.*;

class Main {
    /*
     * 크로아티아 알파벳 조합을 각각 하나의 임시 문자로 치환한다.
     * 모든 치환이 끝난 문자열의 길이가 전체 알파벳 개수다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] patterns = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String pattern : patterns) text = text.replace(pattern, "*");
        System.out.print(text.length());
    }
}
