import java.util.*;

class Solution {
    /*
     * 입력받은 가로 길이만큼 별을 한 줄에 출력한다.
     * 같은 줄을 세로 길이만큼 반복해 직사각형을 만든다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        String line = "*".repeat(width);
        StringBuilder output = new StringBuilder();

        for (int row = 0; row < height; row++) {
            output.append(line).append('\n');
        }

        System.out.print(output);
    }
}
