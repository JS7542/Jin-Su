class Solution {
    /*
     * 첫 문자열을 접두사 후보로 두고 나머지 문자열의 시작 부분과 비교한다.
     * 일치하지 않을 때마다 후보의 마지막 문자를 제거해 공통 접두사를 찾는다.
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
