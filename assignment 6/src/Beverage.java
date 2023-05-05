public abstract class Beverage {
    private String name;
    private String type;
    private int size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 1.0;

    public Beverage(String name, String type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return name + " (" + size + " oz)";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Beverage)) return false;
        Beverage b = (Beverage) o;
        return name.equals(b.getName()) &&
                type.equals(b.getType()) &&
                size == b.getSize();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}