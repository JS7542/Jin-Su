import java.io.*;

class Main {
    /*
     * x와 y의 부호를 확인하여 좌표가 속한 사분면을 결정한다.
     * 두 값은 0이 아니므로 네 가지 경우만 분기한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        int y = Integer.parseInt(br.readLine().trim());

        if (x > 0 && y > 0) System.out.print(1);
        else if (x < 0 && y > 0) System.out.print(2);
        else if (x < 0) System.out.print(3);
        else System.out.print(4);
    }
}
