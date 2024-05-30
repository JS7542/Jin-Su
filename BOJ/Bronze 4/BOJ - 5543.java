import java.io.*;
class Main {
    /*
     * 세 햄버거 중 최솟값과 두 음료 중 최솟값을 각각 찾는다.
     * 두 가격을 더한 뒤 세트 할인 50원을 뺀 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int burger=Integer.MAX_VALUE,drink=Integer.MAX_VALUE;
        for(int i=0;i<3;i++) burger=Math.min(burger,Integer.parseInt(br.readLine()));
        for(int i=0;i<2;i++) drink=Math.min(drink,Integer.parseInt(br.readLine()));
        System.out.print(burger+drink-50);
    }
}
