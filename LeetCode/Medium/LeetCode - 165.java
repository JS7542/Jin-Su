class Solution {
    /*
     * 두 버전 문자열을 점 기준으로 나눈다.
     * 같은 위치의 숫자를 정수로 비교하고 부족한 구간은 0으로 처리한다.
     */
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        int length = Math.max(first.length, second.length);

        for (int i = 0; i < length; i++) {
            int left = i < first.length ? Integer.parseInt(first[i]) : 0;
            int right = i < second.length ? Integer.parseInt(second[i]) : 0;

            if (left < right) return -1;
            if (left > right) return 1;
        }

        return 0;
    }
}
