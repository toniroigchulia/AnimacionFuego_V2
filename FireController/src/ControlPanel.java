import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

    // ATRIBUTOS

    private AnimationControl animationControl;
    private GeneralConfiguration generalConfiguration;
    private ActionListener actionListener;
    private TemperatureConfiguration temperatureConfiguration;

    private DTOGeneralParameters generalParameters;
    private DTOTemperatureParameters temperatureParameters;
    private DTOPaletteParameters paletteConfiguration;
    private DTOFireModelParameters fModelParameters;

    // CONSTRUCTORES

    public ControlPanel(Container panel, ActionListener actionListener) {

        this.actionListener = actionListener;
        this.animationControl = new AnimationControl(panel, actionListener);
        this.generalConfiguration = new GeneralConfiguration(panel);
        this.temperatureConfiguration = new TemperatureConfiguration(panel);

        this.temperatureParameters = new DTOTemperatureParameters();
        this.paletteConfiguration = new DTOPaletteParameters();

        this.generalParameters = new DTOGeneralParameters();
        setDefaultBackgroundImage();
    }

    // GETTERS AND SETTERS

    public AnimationControl getAnimationControl() {
        return animationControl;
    }

    public void setAnimationControl(AnimationControl animationControl) {
        this.animationControl = animationControl;
    }

    public DTOGeneralParameters getGeneralParameters() {
        return generalParameters;
    }

    public void setGeneralParameters(DTOGeneralParameters generalParameters) {
        this.generalParameters = generalParameters;
    }

    public DTOTemperatureParameters getTemperatureParameters() {
        return temperatureParameters;
    }

    public void setTemperatureParameters(DTOTemperatureParameters temperatureParameters) {
        this.temperatureParameters = temperatureParameters;
    }

    public DTOPaletteParameters getPaletteConfiguration() {
        return paletteConfiguration;
    }

    public void setPaletteConfiguration(DTOPaletteParameters paletteConfiguration) {
        this.paletteConfiguration = paletteConfiguration;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public DTOFireModelParameters getfModelParameters() {
        this.fModelParameters = new DTOFireModelParameters(generalParameters, paletteConfiguration,
                temperatureParameters);
        return fModelParameters;
    }

    public void setfModelParameters(DTOFireModelParameters fModelParameters) {
        this.fModelParameters = fModelParameters;
    }

    public GeneralConfiguration getGeneralConfiguration() {
        return generalConfiguration;
    }

    public void setDefaultBackgroundImage() {
        // Al crear el objeto cargamos la imagen de fondo
        try {

            File selectedFile = new File(
                    "C:\\Users\\toni1\\OneDrive\\Documentos\\DAM\\2nDAM\\Interfaces\\AnimacionFuego_V2\\AnimacionFuego_V2\\imagen\\bg.jpg");
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            generalParameters.setBackgroundImage(selectedImage);
            generalConfiguration.setImageParameters(selectedFile.getName(),
                    selectedFile.getParentFile().getName(), selectedImage.getWidth(), selectedImage.getHeight());
        } catch (Exception e) {
            System.err.println("Error loading background. ");
            System.err.println(e);
        }
    }

    public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
    }

    public TemperatureConfiguration getTemperatureConfiguration() {
        return temperatureConfiguration;
    }

    public void setTemperatureConfiguration(TemperatureConfiguration temperatureConfiguration) {
        this.temperatureConfiguration = temperatureConfiguration;
    }
}
