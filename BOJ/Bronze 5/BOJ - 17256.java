import java.io.*; import java.util.*;
class Main {
    /*
     * 정의된 연산 c.x=b.x-a.z, c.y=b.y/a.y, c.z=b.z-a.x를 적용한다.
     * 두 좌표를 입력받아 c의 세 성분을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer a=new StringTokenizer(br.readLine()),b=new StringTokenizer(br.readLine());
        int ax=Integer.parseInt(a.nextToken()),ay=Integer.parseInt(a.nextToken()),az=Integer.parseInt(a.nextToken());
        int bx=Integer.parseInt(b.nextToken()),by=Integer.parseInt(b.nextToken()),bz=Integer.parseInt(b.nextToken());
        System.out.print((bx-az)+" "+(by/ay)+" "+(bz-ax));
    }
}
