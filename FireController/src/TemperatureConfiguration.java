import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class TemperatureConfiguration {

    // ATRIBUTOS

    private JLabel newCoolPixelsPercentageName;
    private JSlider newCoolPixelsPercentage;
    private JLabel newHotPixelsPercentageName;
    private JSlider newHotPixelsPercentage;
    private JLabel cellsPonderationName;
    private JTable cellsPonderation;
    private JLabel cellsDividerName;
    private JTextField cellsDivider;
    private JLabel fixAtenuationFactorName;
    private JTextField fixAtenuationFactor;
    private JToggleButton bottomUpTemps;

    public TemperatureConfiguration(Container panel) {

        addContentToPane(panel);
    }

    private void addContentToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;

        // NewCollPixelsPercentage
        c.gridy = 17;
        c.insets = new Insets(10, 10, 1, 10);
        newCoolPixelsPercentageName = new JLabel("NewCoolPixelsPercentage");
        panel.add(newCoolPixelsPercentageName, c);

        c.gridy++;
        c.insets = new Insets(1, 5, 1, 10);
        newCoolPixelsPercentage = new JSlider(0, 100, 90);
        panel.add(newCoolPixelsPercentage, c);

        // NewHotPixelsPercentage
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        newHotPixelsPercentageName = new JLabel("NewHotPixelsPercentage");
        panel.add(newHotPixelsPercentageName, c);

        c.gridy++;
        c.insets = new Insets(1, 10, 1, 10);
        newHotPixelsPercentage = new JSlider(0, 100, 30);
        panel.add(newHotPixelsPercentage, c);

        // CellsPonderation
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        cellsPonderationName = new JLabel("CellsPonderation");
        panel.add(cellsPonderationName, c);

        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        cellsPonderation = new JTable(2, 3);
        panel.add(cellsPonderation, c);

        // CellsDivider
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        cellsDividerName = new JLabel("CellsDivider");
        panel.add(cellsDividerName, c);

        c.gridy++;
        c.insets = new Insets(1, 10, 1, 10);
        cellsDivider = new JTextField();
        panel.add(cellsDivider, c);

        // FixAtenuationFactor
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        fixAtenuationFactorName = new JLabel("FixAtenuationFactor");
        panel.add(fixAtenuationFactorName, c);

        c.gridy++;
        c.insets = new Insets(1, 10, 10, 10);
        fixAtenuationFactor = new JTextField();
        panel.add(fixAtenuationFactor, c);

        // BottomUpTemps
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        bottomUpTemps = new JToggleButton("BottomUpTemps");
        panel.add(bottomUpTemps, c);
    }

    // GETTERS AND SETTERS

    public float getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage.getValue();
    }

    public float getNewHotPixelsPercentage() {
        return newHotPixelsPercentage.getValue();
    }

    public double[][] getCellsPonderation() {
        double[][] cellsPonderationMatrix = new double[2][3];

        for (int i=0; i < 2; i++){
            for (int j=0; j < 3; j++){

                cellsPonderationMatrix[i][j] = ((Number) cellsPonderation.getValueAt(i, j)).doubleValue();
            }
        }

        return cellsPonderationMatrix;
    }

    public int getCellsDivider() {
        return Integer.parseInt(cellsDivider.getText());
    }

    public double getFixAtenuationFactor() {
        return Double.parseDouble(fixAtenuationFactor.getText());
    }

    public boolean bottomUpTemps() {
        return bottomUpTemps.isSelected();
    } 
}
