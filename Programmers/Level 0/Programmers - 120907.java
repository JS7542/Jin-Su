class Solution {
    /*
     * 각 수식을 공백 단위로 나누어 왼쪽 연산 결과와 오른쪽 값을 비교한다.
     * 맞으면 O, 틀리면 X를 같은 위치의 결과 배열에 저장한다.
     */
    public String[] solution(String[] quiz){String[]a=new String[quiz.length];for(int i=0;i<quiz.length;i++){String[]t=quiz[i].split(" ");int left=Integer.parseInt(t[0])+(t[1].equals("+")?1:-1)*Integer.parseInt(t[2]);a[i]=left==Integer.parseInt(t[4])?"O":"X";}return a;}
}
