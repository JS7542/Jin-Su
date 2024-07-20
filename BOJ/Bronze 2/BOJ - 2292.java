import java.io.*;
class Main {
    /*
     * 벌집의 각 겹은 이전 겹보다 방의 수가 6씩 더 증가한다.
     * 누적 최대 번호가 N 이상이 될 때까지 겹 수를 증가시킨다.
     */
    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int layer=1,max=1;
        while(max<n){max+=6*layer;layer++;}
        System.out.print(layer);
    }
}
