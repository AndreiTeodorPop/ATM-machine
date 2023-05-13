public class User {

    private Card basic;
    private Card gold;

    private User(UserBuilder builder) {
        this.basic = builder.basic;
        this.gold = builder.gold;
    }

    public Card getBasic() {
        return basic;
    }

    public void setBasic(Card basic) {
        this.basic = basic;
    }

    public Card getGold() {
        return gold;
    }

    public void setGold(Card gold) {
        this.gold = gold;
    }

    public static class UserBuilder {
        private Card basic;
        private Card gold;

        public UserBuilder goldCard(Card card) {
            this.gold = card;
            return this;
        }

        public UserBuilder basicCard(Card card) {
            this.basic = card;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }

    }
}
