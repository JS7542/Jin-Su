class Solution {
    /*
     * 숫자의 이진 문자열을 포화 이진트리 노드 수인 2^k-1 길이로 앞쪽 0을 채운다.
     * 더미 노드 0의 하위에 실제 노드 1이 존재하는지 재귀적으로 검사한다.
     */
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int length = 1;

            while (length < binary.length()) length = length * 2 + 1;

            String padded = "0".repeat(length - binary.length()) + binary;
            answer[i] = valid(padded, 0, padded.length() - 1, true) ? 1 : 0;
        }

        return answer;
    }

    private boolean valid(
            String tree,
            int left,
            int right,
            boolean parentReal
    ) {
        if (left > right) return true;

        int middle = (left + right) / 2;
        boolean currentReal = tree.charAt(middle) == '1';

        if (!parentReal && currentReal) return false;

        return valid(tree, left, middle - 1, currentReal)
                && valid(tree, middle + 1, right, currentReal);
    }
}
