import java.util.*;

class Solution {
    /*
     * 전화번호를 사전순으로 정렬한다.
     * 접두사 관계가 있다면 정렬 후 서로 인접한 두 번호 중에서 반드시 발견된다.
     */
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i + 1 < phone_book.length; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}
