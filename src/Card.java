public enum Card {

    BASIC(500),
    GOLD(1000);

    private int value;

    Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    Card EXIT_CODE1(int value) {
        this.value = value;
        return Card.BASIC;
    }

    Card EXIT_CODE2(int value) {
        this.value = value;
        return Card.GOLD;
    }

}
