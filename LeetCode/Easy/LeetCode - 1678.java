class Solution {
    /*
     * Goal Parser의 세 패턴 G, (), (al)을 대응 문자열로 치환한다.
     * 모든 치환이 끝난 해석 결과를 반환한다.
     */
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
