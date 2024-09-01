import java.util.*;

class Solution {
    /*
     * 정수 n을 입력받아 2로 나눈 나머지를 확인한다.
     * 문제에서 요구한 문장 형식으로 짝수 또는 홀수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) System.out.print(n + " is even");
        else System.out.print(n + " is odd");
    }
}
