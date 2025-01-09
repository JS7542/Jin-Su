class Solution {
    /*
     * 전체 대문자, 전체 소문자, 첫 글자만 대문자인 세 가지 올바른 경우를 검사한다.
     * 입력이 이 중 하나와 같으면 true를 반환한다.
     */
    public boolean detectCapitalUse(String word){return word.equals(word.toUpperCase())||word.equals(word.toLowerCase())||word.equals(Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase());}
}
