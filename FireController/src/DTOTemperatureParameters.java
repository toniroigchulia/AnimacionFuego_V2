
public class DTOTemperatureParameters {

    // ATRIBUTOS

    private float newCoolPixelsPercentage = (float) 0.9;
    private float newHotPixelsPercentage = (float) 0.3;
    private double[][] cellsPonderation;
    private int cellsDivider = 6;
    private double fixAtenuationFactor;
    private boolean bottonUpTemps;

    // CONSTRUCTOR

    public DTOTemperatureParameters() {

    }

    // GETTERS AND SETTERS

    public float getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage;
    }

    public void setNewCoolPixelsPercentage(float newCoolPixelsPercentage) {
        this.newCoolPixelsPercentage = newCoolPixelsPercentage;
    }

    public float getNewHotPixelsPercentage() {
        return newHotPixelsPercentage;
    }

    public void setNewHotPixelsPercentage(float newHotPixelsPercentage) {
        this.newHotPixelsPercentage = newHotPixelsPercentage;
    }

    public double[][] getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(double[][] cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public int getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(int cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public double getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }

    public void setFixAtenuationFactor(double fixAtenuationFactor) {
        this.fixAtenuationFactor = fixAtenuationFactor;
    }

    public boolean isBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(boolean bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
        System.out.println(this.bottonUpTemps);
    }
}
