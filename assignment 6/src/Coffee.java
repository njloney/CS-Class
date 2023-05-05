public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_PRICE = 0.5;
    private final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String name, String type, int size, boolean extraShot, boolean extraSyrup) {
        super(name, type, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = super.BASE_PRICE + (super.SIZE_PRICE * (getSize() - 1));
        if (extraShot) price += EXTRA_SHOT_PRICE;
        if (extraSyrup) price += EXTRA_SYRUP_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " - Coffee (" +
                (extraShot ? "extra shot, " : "") +
                (extraSyrup ? "extra syrup, " : "") +
                "$" + calcPrice() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Coffee)) return false;
        Coffee c = (Coffee) o;
        return super.equals(c) &&
                extraShot == c.isExtraShot() &&
                extraSyrup == c.isExtraSyrup();
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
