import java.util.*;

class Solution {
    /*
     * 일, 월 이름, 연도를 분리하고 월 이름을 숫자에 매핑한다.
     * 일과 월을 두 자리로 맞춰 YYYY-MM-DD 형식으로 반환한다.
     */
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        Map<String, Integer> month = new HashMap<>();
        String[] names = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        for (int i = 0; i < names.length; i++) month.put(names[i], i + 1);

        int day = Integer.parseInt(parts[0].replaceAll("\\D", ""));
        return String.format("%s-%02d-%02d", parts[2], month.get(parts[1]), day);
    }
}
