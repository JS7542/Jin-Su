class Solution {
    /*
     * 공백으로 분리된 첫 숫자를 초기값으로 두고 연산자와 다음 숫자를 순서대로 읽는다.
     * +와 -에 따라 누적 결과를 갱신한다.
     */
    public int solution(String my_string){String[]t=my_string.split(" ");int answer=Integer.parseInt(t[0]);for(int i=1;i<t.length;i+=2){int v=Integer.parseInt(t[i+1]);answer+=t[i].equals("+")?v:-v;}return answer;}
}
