import java.util.Random;

public class Temperatures {

    // ATRIBUTOS

    Random rand = new Random();

    public int[][] tempertureMap;
    private int width = 255;
    private int height = 95;

    private float coldPointPercentatge;
    private float sparkPercentatge;
    private double[][] cellsPonderation;
    private int cellsDivider;
    private double fixAtenuationFactor;

    // CONSTRUCTORES

    public Temperatures(DTOTemperatureParameters temperatureParameters) {
        
        this.tempertureMap = new int[height][width];
        setcoldPointPercentatge(temperatureParameters.getNewCoolPixelsPercentage());
        setsparkPercentatge(temperatureParameters.getNewHotPixelsPercentage());
        setCellsPonderation(temperatureParameters.getCellsPonderation());
        setCellsDivider(temperatureParameters.getCellsDivider());
        setFixAtenuationFactor(temperatureParameters.getFixAtenuationFactor());
        
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
        int posInc;
        int posDer;
        int posIzq;

        int posCentD;
        int posDerD;
        int posIzqD;

        // Variable para guardar temperatura
        int mediaTemp;

        for (int i = height - 2; i > -1; i--) {

            // Calculamos la temperatura de la primera columna
            posInc = this.tempertureMap[i][0];
            posDer = this.tempertureMap[i][1];
            posCentD = this.tempertureMap[i + 1][0];
            posDerD = this.tempertureMap[i + 1][1];

            mediaTemp = (posInc + posCentD + posDerD + posDer) / 4;
            this.tempertureMap[i][0] = mediaTemp;

            // Calculamos la temperatura de la ultima columna
            posInc = this.tempertureMap[i][width - 1];
            posCentD = this.tempertureMap[i + 1][width - 1];
            posIzqD = this.tempertureMap[i + 1][width - 2];
            posIzq = this.tempertureMap[i][width - 2];

            mediaTemp = (posInc + posIzqD + posCentD + posIzq) / 4;
            this.tempertureMap[i][width - 1] = mediaTemp;

            // Calculamos todos los valores de entremedias
            for (int j = 1; j < width - 1; j++) {

                posInc = this.tempertureMap[i][j];
                posDer = this.tempertureMap[i][j + 1];
                posIzq = this.tempertureMap[i][j - 1];

                posIzqD = this.tempertureMap[i + 1][j - 1];
                posCentD = this.tempertureMap[i + 1][j];
                posDerD = this.tempertureMap[i + 1][j + 1];

                mediaTemp = (posInc + posIzqD + posCentD + posDerD + posDer + posIzq) / this.cellsDivider;

                this.tempertureMap[i][j] = mediaTemp;
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
}
