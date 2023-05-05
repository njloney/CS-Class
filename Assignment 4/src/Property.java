public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property(String string, String string2, int i, String string3, int j, int k, int l, int m) {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0;
        this.owner = "";
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = plot;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
