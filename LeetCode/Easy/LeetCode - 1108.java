class Solution {
    /*
     * IP 주소의 모든 점 문자를 [.] 문자열로 바꾼다.
     * 변환된 문자열을 그대로 반환한다.
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
