class Solution {
    /*
     * 두 지도의 같은 행을 비트 OR로 합친다.
     * 각 비트를 # 또는 공백으로 바꾸고 n자리 길이를 맞춘다.
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            binary = "0".repeat(n - binary.length()) + binary;
            answer[i] = binary.replace('1', '#').replace('0', ' ');
        }

        return answer;
    }
}
