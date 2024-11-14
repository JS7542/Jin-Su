class Solution {
    /*
     * 각 세금 구간에서 실제 소득이 포함되는 금액만 계산한다.
     * 구간 금액에 세율을 곱해 전체 세금을 누적한다.
     */
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int previous = 0;

        for (int[] bracket : brackets) {
            int taxable = Math.min(income, bracket[0]) - previous;

            if (taxable > 0) tax += taxable * bracket[1] / 100.0;
            if (income <= bracket[0]) break;

            previous = bracket[0];
        }

        return tax;
    }
}
