import java.io.*;
import java.util.*;

class Main {
    /*
     * 한 줄을 StringTokenizer에 전달해 공백 기준으로 단어를 분리한다.
     * 생성된 토큰의 개수를 단어 수로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());
    }
}
