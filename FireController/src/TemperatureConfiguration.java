import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class TemperatureConfiguration extends JPanel {

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

    public TemperatureConfiguration() {
        this.setLayout(new GridBagLayout());
        addContentToPane(this);
        defaultValues();
    }

    private void addContentToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        // NewCollPixelsPercentage
        c.insets = new Insets(10, 10, 1, 10);
        newCoolPixelsPercentageName = new JLabel("CoolPixelsPercentage");
        panel.add(newCoolPixelsPercentageName, c);

        c.gridy++;
        c.insets = new Insets(1, 5, 1, 10);
        newCoolPixelsPercentage = new JSlider(0, 100, 90);
        panel.add(newCoolPixelsPercentage, c);

        // NewHotPixelsPercentage
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        newHotPixelsPercentageName = new JLabel("HotPixelsPercentage");
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
        c.insets = new Insets(5, 10, 1, 10);
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
        c.insets = new Insets(10, 10, 5, 10);
        bottomUpTemps = new JToggleButton("BottomUpTemps");
        panel.add(bottomUpTemps, c);
    }

    public void defaultValues() {
        cellsPonderation.setValueAt("1", 0, 0);
        cellsPonderation.setValueAt("1", 0, 2);
        cellsPonderation.setValueAt("1", 0, 1);
        cellsPonderation.setValueAt("1", 1, 1);
        cellsPonderation.setValueAt("1", 1, 2);
        cellsPonderation.setValueAt("1", 1, 0);

        fixAtenuationFactor.setText("3");
        cellsDivider.setText("5.8");
        newCoolPixelsPercentage.setValue(90);
        newHotPixelsPercentage.setValue(30);
        bottomUpTemps.setSelected(true);
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

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {

                cellsPonderationMatrix[i][j] = Double.parseDouble(cellsPonderation.getValueAt(i, j) + "");
            }
        }

        return cellsPonderationMatrix;
    }

    public double getCellsDivider() {
        return Double.parseDouble(cellsDivider.getText());
    }

    public double getFixAtenuationFactor() {
        return Double.parseDouble(fixAtenuationFactor.getText());
    }

    public boolean bottomUpTemps() {
        return bottomUpTemps.isSelected();
    }
}