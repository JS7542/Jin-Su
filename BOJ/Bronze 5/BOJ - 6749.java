import java.io.*;

class Main {
    /*
     * 세 사람의 나이는 같은 간격의 등차수열을 이룬다.
     * 가장 나이 많은 사람의 나이는 2×중간 나이-막내 나이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int youngest = Integer.parseInt(br.readLine());
        int middle = Integer.parseInt(br.readLine());

        System.out.print(middle * 2 - youngest);
    }
}
