class Solution {
    /*
     * 마지막 네 자리를 제외한 앞부분을 별표로 채운다.
     * 별표 문자열과 원본의 마지막 네 자리를 이어 붙여 반환한다.
     */
    public String solution(String phone_number) {
        return "*".repeat(phone_number.length() - 4)
                + phone_number.substring(phone_number.length() - 4);
    }
}
