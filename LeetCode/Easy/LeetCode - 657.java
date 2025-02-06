class Solution {
    /*
     * U와 D는 y좌표를, L과 R은 x좌표를 반대 방향으로 변화시킨다.
     * 모든 이동 후 두 좌표가 모두 0인지 확인한다.
     */
    public boolean judgeCircle(String moves){int x=0,y=0;for(char c:moves.toCharArray()){if(c=='U')y++;else if(c=='D')y--;else if(c=='L')x--;else x++;}return x==0&&y==0;}
}
