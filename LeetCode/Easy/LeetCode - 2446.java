class Solution {
    /*
     * 두 이벤트가 겹치지 않으려면 하나의 종료 시간이 다른 시작 시간보다 빨라야 한다.
     * 그 반대인 두 구간의 교집합 존재 여부를 문자열 시간 비교로 확인한다.
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0
                && event2[0].compareTo(event1[1]) <= 0;
    }
}
