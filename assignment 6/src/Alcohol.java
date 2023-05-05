class Alcohol extends Beverage {
    private boolean weekendOffer;

    private final double WEEKEND_PRICE = 0.6;

    public Alcohol(String name, String type, int size, boolean weekendOffer) {
        super(name, type, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice() + getSizePrice() * getSize();
        if (weekendOffer) {
            price += WEEKEND_PRICE;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s", getName(), getSizeName(), (weekendOffer ? "Weekend Offer" : "Regular Price"));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alcohol) {
            Alcohol other = (Alcohol) obj;
            return super.equals(other) && weekendOffer == other.weekendOffer;
        }
        return false;
    }

    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }

    protected double getWeekendPrice() {
        return WEEKEND_PRICE;
    }
}