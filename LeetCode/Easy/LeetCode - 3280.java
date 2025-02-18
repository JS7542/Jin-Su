class Solution {
    /*
     * 날짜를 연, 월, 일 정수로 분리한다.
     * 각 값을 이진 문자열로 변환해 하이픈으로 이어 붙인다.
     */
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        return Integer.toBinaryString(Integer.parseInt(parts[0]))
                + "-" + Integer.toBinaryString(Integer.parseInt(parts[1]))
                + "-" + Integer.toBinaryString(Integer.parseInt(parts[2]));
    }
}
