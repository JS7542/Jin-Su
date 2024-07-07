import java.io.*;
class Main {
    /*
     * 대각선 길이를 차례로 빼며 X가 속한 대각선과 그 안의 위치를 찾는다.
     * 대각선 번호의 홀짝에 따라 분자와 분모의 증가 방향을 결정한다.
     */
    public static void main(String[] args) throws Exception {
        int x=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()); int line=1;
        while(x>line){x-=line;line++;}
        int a,b; if(line%2==0){a=x;b=line-x+1;}else{a=line-x+1;b=x;}
        System.out.print(a+"/"+b);
    }
}
