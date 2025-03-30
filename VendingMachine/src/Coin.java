public enum Coin {

    COIN_1(1), COIN_2(2), COIN_5(5);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
