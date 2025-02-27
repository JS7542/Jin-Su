import java.time.*;

class Solution {
    /*
     * 입력 날짜로 LocalDate 객체를 생성한다.
     * 요일 이름을 문제 형식에 맞게 첫 문자만 대문자로 변환한다.
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String name = LocalDate.of(year, month, day).getDayOfWeek().name().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
