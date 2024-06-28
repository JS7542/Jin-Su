class Solution {
    /*
     * 짝수 인덱스 문자열은 소문자, 홀수 인덱스 문자열은 대문자로 바꾼다.
     * 변환한 문자열을 같은 배열 위치에 저장해 반환한다.
     */
    public String[] solution(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
        }
        return strArr;
    }
}
