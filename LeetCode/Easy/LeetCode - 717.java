class Solution {
    /*
     * 0은 한 비트 문자이므로 한 칸, 1은 두 비트 문자이므로 두 칸 이동한다.
     * 마지막 문자에 도착한 상태인지 확인해 한 비트 문자인지 판단한다.
     */
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;

        while (index < bits.length - 1) {
            index += bits[index] == 0 ? 1 : 2;
        }

        return index == bits.length - 1;
    }
}
