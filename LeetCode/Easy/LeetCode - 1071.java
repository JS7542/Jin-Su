class Solution {
    /*
     * 두 문자열을 이어 붙인 순서가 다르면 같은 반복 단위로 만들 수 없다.
     * 가능하면 두 길이의 최대공약수만큼 앞부분을 반환한다.
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
