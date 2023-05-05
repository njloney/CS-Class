public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    public ManagementCompany() {
        name = "";
        taxID = "";
        mgmFee = 0;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        numberOfProperties = 0;
    }

    public String getName() {
        return name;
    }
    public Plot getPlot() {
    	return plot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public double getMgmFee() {
        return mgmFee;
    }

    public void setMgmFee(double mgmFee) {
        this.mgmFee = mgmFee;
    }

    public int addProperty(Property p) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; // array is full
        }
        if (p == null) {
            return -2; // property is null
        }
        if (!plot.encompasses(p.getPlot())) {
            return -3; // plot is not encompassed by management plot
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(p.getPlot())) {
                return -4; // plot overlaps with existing property plot
            }
        }
        properties[numberOfProperties] = p;
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).
        append(", taxID: ").append(taxID).append("\n");
        sb.append("\n");
        for (int i = 0; i < numberOfProperties; i++) {
        sb.append(properties[i].toString()).append("\n");
        }
        sb.append("\n");
        sb.append("total management fee: ").append(getTotalManagementFee()).append("\n");
        return sb.toString();
        }
    public double getTotalManagementFee() {
        return (getTotalRent() * (mgmFee / 100));
    }
}