import java.io.*;
class Main {
    /*
     * 아홉 난쟁이의 합에서 두 명의 키를 제외해 100이 되는 조합을 찾는다.
     * 제외할 두 인덱스를 찾은 뒤 나머지 일곱 키를 입력 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); int[] a=new int[9]; int sum=0;
        for(int i=0;i<9;i++){a[i]=Integer.parseInt(br.readLine());sum+=a[i];}
        int x=-1,y=-1;
        outer:for(int i=0;i<8;i++)for(int j=i+1;j<9;j++)if(sum-a[i]-a[j]==100){x=i;y=j;break outer;}
        StringBuilder sb=new StringBuilder(); for(int i=0;i<9;i++)if(i!=x&&i!=y)sb.append(a[i]).append('\n');
        System.out.print(sb);
    }
}
