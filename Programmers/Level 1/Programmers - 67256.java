class Solution {
    /*
     * 왼손은 1·4·7, 오른손은 3·6·9를 고정으로 누른다.
     * 가운데 열 숫자는 두 엄지의 맨해튼 거리를 비교하고 같으면 주 사용 손을 따른다.
     */
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            int target = number == 0 ? 11 : number;

            if (number == 1 || number == 4 || number == 7) {
                answer.append('L');
                left = target;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append('R');
                right = target;
            } else {
                int leftDistance = distance(left, target);
                int rightDistance = distance(right, target);

                if (leftDistance < rightDistance
                        || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append('L');
                    left = target;
                } else {
                    answer.append('R');
                    right = target;
                }
            }
        }

        return answer.toString();
    }

    private int distance(int from, int to) {
        int fromRow = (from - 1) / 3;
        int fromCol = (from - 1) % 3;
        int toRow = (to - 1) / 3;
        int toCol = (to - 1) % 3;

        return Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
    }
}
