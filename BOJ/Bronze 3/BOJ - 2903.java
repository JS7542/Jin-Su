import java.io.*;
class Main {
    /*
     * 한 변의 점 개수는 단계마다 현재 간격 수가 두 배가 되어 2^N+1이 된다.
     * 정사각형 전체 점의 수는 한 변 점 개수의 제곱이다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());int side=(1<<n)+1;
        System.out.print(side*side);
    }
}
