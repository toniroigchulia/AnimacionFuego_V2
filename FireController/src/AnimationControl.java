import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AnimationControl extends JPanel {

    // ATRIBUTOS

    private JButton playPause;
    private JButton reset;
    private JButton aplly;
    private JButton stopButton;
    private JButton imageButton;

    private ActionListener actionListener;
    private Container panel;

    // CONSTRUCTOR

    public AnimationControl(Container panel, ActionListener actionListener) {

        this.panel = panel;
        this.actionListener = actionListener;

        addButtonsToPane(this.panel);
    }

    // METODOS

    // Grid de los botones
    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);

        // Play
        this.playPause = new JButton("Play");
        this.playPause.addActionListener(actionListener);
        panel.add(this.playPause, c);

        // Stop
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(actionListener);
        panel.add(stopButton, c);

        // Apply
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        aplly = new JButton("Apply");
        aplly.addActionListener(actionListener);
        panel.add(aplly, c);

        // Reset
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        reset = new JButton("Reset");
        reset.addActionListener(actionListener);
        panel.add(reset, c);

        // ImageButton
        c.gridy = 13;
        c.insets = new Insets(10, 10, 10, 10);
        imageButton = new JButton("Change Background");
        imageButton.addActionListener(actionListener);
        panel.add(imageButton, c);

    }

    // GETTERS AND SETTERS

    public JButton getPlayPause() {
        return playPause;
    }

    public JButton getReset() {
        return reset;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JButton getAplly() {
        return aplly;
    }

    public Container getPanel() {
        return panel;
    }
}
