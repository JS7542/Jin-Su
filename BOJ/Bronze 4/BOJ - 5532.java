import java.io.*;

class Main {
    /*
     * 국어와 수학 숙제에 필요한 최소 일수를 각각 올림 나눗셈으로 구한다.
     * 두 숙제 일수 중 큰 값을 전체 방학 일수에서 뺀다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vacation = Integer.parseInt(br.readLine());
        int koreanPages = Integer.parseInt(br.readLine());
        int mathPages = Integer.parseInt(br.readLine());
        int koreanPerDay = Integer.parseInt(br.readLine());
        int mathPerDay = Integer.parseInt(br.readLine());

        int koreanDays = (koreanPages + koreanPerDay - 1) / koreanPerDay;
        int mathDays = (mathPages + mathPerDay - 1) / mathPerDay;

        System.out.print(vacation - Math.max(koreanDays, mathDays));
    }
}
