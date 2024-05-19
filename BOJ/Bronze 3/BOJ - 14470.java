import java.io.*;
class Main {
    /*
     * 고기가 0도 미만이면 해동, 0도 가열, 양의 온도 가열 시간을 각각 계산한다.
     * 시작 온도에 따라 필요한 단계의 시간을 합산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine()),b=Integer.parseInt(br.readLine()),c=Integer.parseInt(br.readLine()),d=Integer.parseInt(br.readLine()),e=Integer.parseInt(br.readLine());
        int answer=a<0?(-a)*c+d+b*e:(b-a)*e;
        System.out.print(answer);
    }
}
