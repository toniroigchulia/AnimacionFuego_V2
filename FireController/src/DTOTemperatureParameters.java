
public class DTOTemperatureParameters {

    // ATRIBUTOS

    private float newCoolPixelsPercentage = 0.9f;
    private float newHotPixelsPercentage = 0.3f;
    private double[][] cellsPonderation = new double[2][3];
    private double cellsDivider = 6.2;
    private double fixAtenuationFactor = 4;
    private boolean bottonUpTemps;

    // CONSTRUCTOR

    public DTOTemperatureParameters() {
        
        setDefaultCellPonderation();
    }

    // GETTERS AND SETTERS

    public float getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage;
    }

    public void setNewCoolPixelsPercentage(float newCoolPixelsPercentage) {
        this.newCoolPixelsPercentage = newCoolPixelsPercentage / 100;
    }

    public float getNewHotPixelsPercentage() {
        return newHotPixelsPercentage;
    }

    public void setNewHotPixelsPercentage(float newHotPixelsPercentage) {
        this.newHotPixelsPercentage = newHotPixelsPercentage / 100;
    }

    public double[][] getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(double[][] cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public double getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(double cellsDivider) {
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
    }
    
    public void setDefaultCellPonderation() {
        
        this.cellsPonderation[0][0] = this.cellsPonderation[0][2] = 1.2d;
        this.cellsPonderation[0][1] = 1.5d;
        this.cellsPonderation[1][0] = this.cellsPonderation[1][1] = this.cellsPonderation[1][2] = 0.7d;
    }
}
