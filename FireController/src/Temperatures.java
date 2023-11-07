import java.util.Random;

public class Temperatures {

    // ATRIBUTOS

    Random rand = new Random();

    public double[][] tempertureMap;
    private int width = 255;
    private int height = 95;

    private float coldPointPercentatge;
    private float sparkPercentatge;
    private double[][] cellsPonderation;
    private double cellsDivider;
    private double fixAtenuationFactor;
    private boolean bottonUpTemps;

    // CONSTRUCTORES

    public Temperatures(DTOTemperatureParameters temperatureParameters) {

        this.tempertureMap = new double[height][width];
        setcoldPointPercentatge(temperatureParameters.getNewCoolPixelsPercentage());
        setsparkPercentatge(temperatureParameters.getNewHotPixelsPercentage());
        setCellsPonderation(temperatureParameters.getCellsPonderation());
        setCellsDivider(temperatureParameters.getCellsDivider());
        setFixAtenuationFactor(temperatureParameters.getFixAtenuationFactor());
        setBottonUpTemps(temperatureParameters.isBottonUpTemps());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.tempertureMap[i][j] = 0;
            }
        }
    }

    // METODOS

    // Actualizar el mapa
    public void next() {

        cold();
        spark();
        calc();
    }

    // Enfriar el mapa
    private void cold() {

        for (int i = 0; i < width; i++) {

            double r = rand.nextDouble(1);

            if (r < coldPointPercentatge) {

                this.tempertureMap[height - 1][i] = 0;
            }
        }
    }

    // Crear chispas
    private void spark() {

        for (int i = 0; i < width; i++) {

            double r = rand.nextDouble(1);

            if (r < sparkPercentatge) {

                this.tempertureMap[height - 1][i] = 255;
            }
        }
    }

    // Calcular las temperaturas
    private void calc() {

        // Variables para posiciones
        double posInc;
        double posDer;
        double posIzq;

        double posCentD;
        double posDerD;
        double posIzqD;

        // Variable para guardar temperatura
        int mediaTemp;

        if (bottonUpTemps) {
            for (int i = height - 2; i >= 0; i--) {

                // Calculamos la temperatura de la primera columna
                posInc = (this.tempertureMap[i][0] * cellsPonderation[0][1]);
                posDer = (this.tempertureMap[i][1] * cellsPonderation[0][2]);
                posCentD = (this.tempertureMap[i + 1][0] * cellsPonderation[1][1]);
                posDerD = (this.tempertureMap[i + 1][1] * cellsPonderation[1][2]);

                mediaTemp = (int) (((posInc + posCentD + posDerD + posDer) / (this.cellsDivider))
                        - fixAtenuationFactor);
                this.tempertureMap[i][0] = mediaTemp;

                // Calculamos la temperatura de la ultima columna
                posInc = (this.tempertureMap[i][width - 1] * cellsPonderation[0][1]);
                posCentD = (this.tempertureMap[i + 1][width - 1] * cellsPonderation[1][1]);
                posIzqD = (this.tempertureMap[i + 1][width - 2] * cellsPonderation[1][0]);
                posIzq = (this.tempertureMap[i][width - 2] * cellsPonderation[0][0]);

                mediaTemp = (int) (((posInc + posIzqD + posCentD + posIzq) / (this.cellsDivider))
                        - fixAtenuationFactor);
                this.tempertureMap[i][width - 1] = mediaTemp;

                // Calculamos todos los valores de entremedias
                for (int j = 1; j < width - 1; j++) {

                    posInc = (this.tempertureMap[i][j] * cellsPonderation[0][1]);
                    posDer = (this.tempertureMap[i][j + 1] * cellsPonderation[0][2]);
                    posIzq = (this.tempertureMap[i][j - 1] * cellsPonderation[0][0]);

                    posIzqD = (this.tempertureMap[i + 1][j - 1] * cellsPonderation[0][0]);
                    posCentD = (this.tempertureMap[i + 1][j] * cellsPonderation[1][1]);
                    posDerD = (this.tempertureMap[i + 1][j + 1] * cellsPonderation[1][2]);

                    mediaTemp = (int) (((posInc + posIzqD + posCentD + posDerD + posDer + posIzq) / this.cellsDivider)
                            - fixAtenuationFactor);

                    this.tempertureMap[i][j] = mediaTemp;
                }
            }

        } else {
            for (int i = 0; i < height - 1; i++) {
                // Calculamos la temperatura de la primera columna
                posInc = (this.tempertureMap[i][0] * cellsPonderation[0][1]);
                posDer = (this.tempertureMap[i][1] * cellsPonderation[0][2]);
                posCentD = (this.tempertureMap[i + 1][0] * cellsPonderation[1][1]);
                posDerD = (this.tempertureMap[i + 1][1] * cellsPonderation[1][2]);

                mediaTemp = (int) (((posInc + posCentD + posDerD + posDer) / (this.cellsDivider))
                        - fixAtenuationFactor);
                this.tempertureMap[i][0] = mediaTemp;

                // Calculamos la temperatura de la ultima columna
                posInc = (this.tempertureMap[i][width - 1] * cellsPonderation[0][1]);
                posCentD = (this.tempertureMap[i + 1][width - 1] * cellsPonderation[1][1]);
                posIzqD = (this.tempertureMap[i + 1][width - 2] * cellsPonderation[1][0]);
                posIzq = (this.tempertureMap[i][width - 2] * cellsPonderation[0][0]);

                mediaTemp = (int) (((posInc + posIzqD + posCentD + posIzq) / (this.cellsDivider))
                        - fixAtenuationFactor);
                this.tempertureMap[i][width - 1] = mediaTemp;

                // Calculamos todos los valores de entremedias
                for (int j = 1; j < width - 1; j++) {

                    posInc = (this.tempertureMap[i][j] * cellsPonderation[0][1]);
                    posDer = (this.tempertureMap[i][j + 1] * cellsPonderation[0][2]);
                    posIzq = (this.tempertureMap[i][j - 1] * cellsPonderation[0][0]);

                    posIzqD = (this.tempertureMap[i + 1][j - 1] * cellsPonderation[0][0]);
                    posCentD = (this.tempertureMap[i + 1][j] * cellsPonderation[1][1]);
                    posDerD = (this.tempertureMap[i + 1][j + 1] * cellsPonderation[1][2]);

                    mediaTemp = (int) (((posInc + posIzqD + posCentD + posDerD + posDer + posIzq) / this.cellsDivider)
                            - fixAtenuationFactor);

                    this.tempertureMap[i][j] = mediaTemp;
                }
            }
        }
    }

    // GETTERS AND SETTERS

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setcoldPointPercentatge(float coldChance) {
        this.coldPointPercentatge = coldChance;
    }

    public void setsparkPercentatge(float sparkChance) {
        this.sparkPercentatge = sparkChance;
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
}
