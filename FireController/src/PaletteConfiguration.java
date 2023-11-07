import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PaletteConfiguration extends JPanel {

    private JLabel colorTargetName;
    private JTable colorTargetTable;

    public PaletteConfiguration() {
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
        
        // CellsPonderation
        c.gridy++;
        c.insets = new Insets(10, 10, 1, 10);
        colorTargetName = new JLabel("ColorTargets");
        panel.add(colorTargetName, c);

        c.gridy++;
        c.insets = new Insets(10, 10, 10, 10);
        colorTargetTable = new JTable(8, 2);
        panel.add(colorTargetTable, c);
    }

    private void defaultValues() {
    }
}