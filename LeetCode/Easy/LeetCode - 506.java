import java.util.*;
class Solution {
    /*
     * 점수와 원래 인덱스를 함께 정렬해 높은 점수부터 순위를 부여한다.
     * 상위 세 명은 메달 이름, 나머지는 숫자 순위를 원래 위치에 저장한다.
     */
    public String[] findRelativeRanks(int[] score){Integer[]idx=new Integer[score.length];for(int i=0;i<idx.length;i++)idx[i]=i;Arrays.sort(idx,(a,b)->Integer.compare(score[b],score[a]));String[]r=new String[score.length];String[]m={"Gold Medal","Silver Medal","Bronze Medal"};for(int i=0;i<idx.length;i++)r[idx[i]]=i<3?m[i]:String.valueOf(i+1);return r;}
}
