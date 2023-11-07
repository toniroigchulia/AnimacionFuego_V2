import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ControlPanel extends JPanel {

    // ATRIBUTOS

    private AnimationControl animationControl;
    private GeneralConfiguration generalConfiguration;
    private ActionListener actionListener;
    private TemperatureConfiguration temperatureConfiguration;
    private PaletteConfiguration paletteConfiguration;

    private DTOGeneralParameters generalParameters;
    private DTOTemperatureParameters temperatureParameters;
    private DTOPaletteParameters paletteParameters;
    private DTOFireModelParameters fModelParameters;

    // CONSTRUCTORES

    public ControlPanel(ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        this.actionListener = actionListener;
        
        initiatePanels();
        
        this.temperatureParameters = new DTOTemperatureParameters();
        this.paletteParameters = new DTOPaletteParameters();
        this.generalParameters = new DTOGeneralParameters();
        setDefaultBackgroundImage();
    }

    public void initiatePanels() {
        this.removeAll();
        
        this.animationControl = new AnimationControl(actionListener);
        this.animationControl.setBorder(new LineBorder(Color.BLACK, 2));

        this.generalConfiguration = new GeneralConfiguration(actionListener);
        this.generalConfiguration.setBorder(new LineBorder(Color.BLACK, 2));

        this.temperatureConfiguration = new TemperatureConfiguration();
        this.temperatureConfiguration.setBorder(new LineBorder(Color.BLACK, 2));

        this.paletteConfiguration = new PaletteConfiguration();
        this.paletteConfiguration.setBorder(new LineBorder(Color.BLACK, 2));

        addPanels();
    }

    private void addPanels() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(animationControl, c);

        c.gridx = 1;
        c.gridy = 0;
        this.add(generalConfiguration, c);

        c.gridy = 1;
        this.add(temperatureConfiguration, c);

        c.gridy = 1;
        c.gridx = 0;
        this.add(paletteConfiguration, c);
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

    public PaletteConfiguration getPaletteConfiguration() {
        return paletteConfiguration;
    }

    public void setPaletteConfiguration(DTOPaletteParameters paletteParameters) {
        this.paletteParameters = paletteParameters;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public DTOFireModelParameters getfModelParameters() {
        this.fModelParameters = new DTOFireModelParameters(generalParameters, paletteParameters,
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
                    "imagen\\bg.jpg");
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

    public void setPaletteConfiguration(PaletteConfiguration paletteConfiguration) {
        this.paletteConfiguration = paletteConfiguration;
    }

    public DTOPaletteParameters getPaletteParameters() {
        return paletteParameters;
    }

    public void setPaletteParameters(DTOPaletteParameters paletteParameters) {
        this.paletteParameters = paletteParameters;
    }
}
