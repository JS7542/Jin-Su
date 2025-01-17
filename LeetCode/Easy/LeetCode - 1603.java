class ParkingSystem {
    /*
     * 차종별 남은 주차 공간을 배열에 저장한다.
     * 차량이 들어올 때 해당 공간이 있으면 감소시키고 true를 반환한다.
     */
    private final int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (spaces[carType] == 0) return false;
        spaces[carType]--;
        return true;
    }
}
