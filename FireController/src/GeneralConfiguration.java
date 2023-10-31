import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Insets;
import java.awt.event.ActionListener;

public class GeneralConfiguration extends JPanel{

    // ATRIBUTOS

    private JLabel heighName;
    private JTextField heigh;
    private JLabel widthName;
    private JTextField width;
    private JLabel posxName;
    private JTextField posX;
    private JLabel posyName;
    private JTextField posY;
    private JLabel imageName;
    private JLabel directName;
    private JLabel imgResolution;
    private ActionListener actionListener;

    // CONTRUCTOR

    public GeneralConfiguration(ActionListener actionListener) {
        
        this.actionListener = actionListener;
    
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(border);
        this.setVisible(true);
        
        this.setLayout(new GridBagLayout());
        addButtonsToPane(this);
    }

    // METODOS

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        // Heigh
        c.gridy = 7;
        c.insets = new Insets(10, 10, 1, 10);
        this.heighName = new JLabel("Heigh");
        panel.add(heighName, c);

        c.gridy = 8;
        c.insets = new Insets(1, 10, 1, 10);
        heigh = new JTextField(20);
        heigh.setText("0");
        panel.add(heigh, c);

        // Width
        c.gridy = 9;
        c.insets = new Insets(10, 10, 1, 10);
        widthName = new JLabel("Width");
        panel.add(widthName, c);

        c.gridy = 10;
        c.insets = new Insets(1, 10, 1, 10);
        width = new JTextField(20);
        width.setText("0");
        panel.add(width, c);

        // PosX
        c.gridy = 11;
        c.insets = new Insets(10, 10, 1, 10);
        posxName = new JLabel("PosX");
        panel.add(posxName, c);

        c.gridy = 12;
        c.insets = new Insets(1, 10, 1, 10);
        posX = new JTextField(20);
        posX.setText("0");
        panel.add(posX, c);

        // PosY
        c.gridy = 13;
        c.insets = new Insets(10, 10, 1, 10);
        posyName = new JLabel("PosY");
        panel.add(posyName, c);

        c.gridy = 14;
        c.insets = new Insets(1, 10, 1, 10);
        posY = new JTextField(20);
        posY.setText("0");
        panel.add(posY, c);

        // Nombre Imagen
        c.gridy = 15;
        c.insets = new Insets(10, 10, 1, 10);
        imageName = new JLabel("");
        panel.add(imageName, c);

        // Directorio de la imagen
        c.gridy = 16;
        c.insets = new Insets(10, 10, 1, 10);
        directName = new JLabel("");
        panel.add(directName, c);

        // Reslucion imagen
        c.gridy = 17;
        c.insets = new Insets(10, 10, 1, 10);
        imgResolution = new JLabel("");
        panel.add(imgResolution, c);
    }

    public void resetValues() {

        heigh.setText("0");
        width.setText("0");
        posY.setText("0");
        posX.setText("0");
    }

    // GETTERS AND SETTERS

    public JLabel getHeighName() {
        return heighName;
    }

    public int getHeigh() {
        return Integer.parseInt(heigh.getText());
    }

    public JLabel getWidthName() {
        return widthName;
    }

    public int getWidth() {
        return Integer.parseInt(width.getText());
    }

    public JLabel getPosxName() {
        return posxName;
    }

    public int getPosX() {
        return Integer.parseInt(posX.getText());
    }

    public JLabel getPosyName() {
        return posyName;
    }

    public int getPosY() {
        return Integer.parseInt(posY.getText());
    }

    public void setImageParameters(String imgName, String direcName, int imgWidht, int imgHeight) {

        imageName.setText("Image Name: " + imgName);
        directName.setText("Directory Name: " + direcName);
        imgResolution.setText("Image Resolution: " + imgWidht + " x " + imgHeight);
    }
}
