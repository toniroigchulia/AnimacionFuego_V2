import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ControlPanel extends JPanel {

    // ATRIBUTOS
    private JButton test;
    
    private AnimationControl animationControl;
    private GeneralConfiguration generalConfiguration;
    private ActionListener actionListener;

    private DTOGeneralParameters generalParameters;
    private DTOTemperatureParameters temperatureParameters;
    private DTOPaletteParameters paletteConfiguration;
    private DTOFireModelParameters fModelParameters;

    // CONSTRUCTORES

    public ControlPanel(ActionListener actionListener) {

        this.actionListener = actionListener;
        setLayout(new GridBagLayout());
        
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(border);
        this.animationControl = new AnimationControl(actionListener);
        this.generalConfiguration = new GeneralConfiguration(actionListener);

        addAnimationControl();
        addGeneralConfiguration();

        this.temperatureParameters = new DTOTemperatureParameters();
        this.paletteConfiguration = new DTOPaletteParameters();
        this.generalParameters = new DTOGeneralParameters();

        setDefaultBackgroundImage();
        repaint();
    }

    // METODOS

    public void addAnimationControl() {
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(border);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 0;
        c.gridwidth = 1;

        this.add(this.animationControl, c);
    }

    public void addGeneralConfiguration() {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 0;
        c.gridwidth = 1;

        this.add(this.generalConfiguration, c);
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
}
