class Solution {
    /*
     * 보유한 5달러와 10달러 지폐 수를 관리한다.
     * 거스름돈은 큰 지폐 조합을 우선 사용하고 불가능하면 false를 반환한다.
     */
    public boolean lemonadeChange(int[] bills){int five=0,ten=0;for(int b:bills){if(b==5)five++;else if(b==10){if(five--==0)return false;ten++;}else if(ten>0&&five>0){ten--;five--;}else if(five>=3)five-=3;else return false;}return true;}
}
