import java.awt.Color;
import java.awt.image.BufferedImage;

public class FireModel extends BufferedImage {

    // ATRIBUTOS

    private int width, height;
    private int posX, posY;
    private ColorPalette colorPalette;
    private Temperatures temperatures;

    // CONSTRUCTOR

    public FireModel(DTOFireModelParameters fireModelParameters) {
        super(255, 95 , BufferedImage.TYPE_INT_ARGB);
        
        DTOGeneralParameters generalParameters = fireModelParameters.getGeneralParameters();
        this.width = generalParameters.getFireWidth();
        this.height = generalParameters.getFireHight();
        this.posX = generalParameters.getFirXPosition();
        this.posY = generalParameters.getFireYPosition();

        // Color Palette
        this.colorPalette = new ColorPalette(fireModelParameters.getPaletteConfiguration().getColorTargets());
        this.colorPalette.calc();

        // Temperaturas
        this.temperatures = new Temperatures(fireModelParameters.getTemperatureParameters());
    }

    // METODOS

    // Metodo para crear la imagen
    private void createFireImage() {

        temperatures.next();

        for (int i = 0; i < temperatures.getHeight() - 2; i++) {
            for (int j = 0; j < temperatures.getWidth(); j++) {

                int tempAct = (int) (temperatures.tempertureMap[i][j]);
                
                if (tempAct > 255) {
                
                    tempAct = 255;
                } else if (tempAct < 0) {
                
                    tempAct = 0;
                }
                
                Color colorAct = colorPalette.colorsPalette[tempAct];

                this.setRGB(j, i, colorAct.getRGB());
            }
        }
    }

    // Metodo que se ejecuta cuando se necesitamos la siguiente imagen
    public void next() {

        createFireImage();
    }

    // GETTERS AND SETTERS

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
