class Solution {
    /*
     * 여벌을 도난당한 학생을 먼저 상쇄한 뒤 작은 번호 학생부터 빌려준다.
     * 최종적으로 체육복을 가진 학생 수를 계산한다.
     */
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];
        for (int student = 1; student <= n; student++) clothes[student] = 1;
        for (int student : lost) clothes[student]--;
        for (int student : reserve) clothes[student]++;

        for (int student = 1; student <= n; student++) {
            if (clothes[student] != 0) continue;

            if (student > 1 && clothes[student - 1] == 2) {
                clothes[student - 1]--;
                clothes[student]++;
            } else if (student < n && clothes[student + 1] == 2) {
                clothes[student + 1]--;
                clothes[student]++;
            }
        }

        int answer = 0;
        for (int student = 1; student <= n; student++) {
            if (clothes[student] > 0) answer++;
        }
        return answer;
    }
}
