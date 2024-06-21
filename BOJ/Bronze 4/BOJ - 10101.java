import java.io.*;

class Main {
    /*
     * 세 각의 합이 180인지 먼저 확인한다.
     * 합이 맞으면 같은 각의 개수에 따라 정삼각형, 이등변, 일반 삼각형을 구분한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (a + b + c != 180) System.out.print("Error");
        else if (a == 60 && b == 60 && c == 60) System.out.print("Equilateral");
        else if (a == b || b == c || a == c) System.out.print("Isosceles");
        else System.out.print("Scalene");
    }
}
