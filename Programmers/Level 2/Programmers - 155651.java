import java.util.*;

class Solution {
    /*
     * 예약을 시작 시각순으로 정렬하고 사용 중인 객실의 청소 완료 시각을 최소 힙에 저장한다.
     * 가장 빠른 완료 시각이 새 예약 시작 이하이면 같은 객실을 재사용한다.
     */
    public int solution(String[][] book_time) {
        int[][] bookings = new int[book_time.length][2];

        for (int index = 0; index < book_time.length; index++) {
            bookings[index][0] = minutes(book_time[index][0]);
            bookings[index][1] = minutes(book_time[index][1]) + 10;
        }

        Arrays.sort(bookings, Comparator.comparingInt(booking -> booking[0]));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] booking : bookings) {
            if (!rooms.isEmpty() && rooms.peek() <= booking[0]) {
                rooms.poll();
            }

            rooms.offer(booking[1]);
        }

        return rooms.size();
    }

    private int minutes(String time) {
        String[] parts = time.split(":");

        return Integer.parseInt(parts[0]) * 60
                + Integer.parseInt(parts[1]);
    }
}
