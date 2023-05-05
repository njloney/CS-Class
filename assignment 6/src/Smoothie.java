public class Smoothie extends Beverage {
    private int numFruits;
    private boolean hasProteinPowder;
    private final double PROTEIN_PRICE = 1.5;
    private final double FRUIT_PRICE = 0.5;

    public Smoothie(String name, String type, String size, int numFruits, boolean hasProteinPowder) {
        super(name, type, size);
        this.numFruits = numFruits;
        this.hasProteinPowder = hasProteinPowder;
    }

    @Override
    public double calcPrice() {
        double price = getBASE_PRICE();
        if (getSize().equals("large")) {
            price += getSIZE_PRICE();
        }
        if (hasProteinPowder) {
            price += PROTEIN_PRICE;
        }
        price += numFruits * FRUIT_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " with " + numFruits + " fruits" + (hasProteinPowder ? " and protein" : "") + " (" + calcPrice() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Smoothie) {
            Smoothie other = (Smoothie) obj;
            return super.equals(other) && this.numFruits == other.numFruits && this.hasProteinPowder == other.hasProteinPowder;
        }
        return false;
    }

    // getters and setters
    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean hasProteinPowder() {
        return hasProteinPowder;
    }

    public void setHasProteinPowder(boolean hasProteinPowder) {
        this.hasProteinPowder = hasProteinPowder;
    }

    public double getPROTEIN_PRICE() {
        return PROTEIN_PRICE;
    }

    public double getFRUIT_PRICE() {
        return FRUIT_PRICE;
    }
}
