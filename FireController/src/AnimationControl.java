import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private ActionListener actionListener;

    // CONSTRUCTOR

    public AnimationControl(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.setLayout(new GridBagLayout());
        addButtonsToPane(this);
    }

    // METODOS

    // Grid de los botones
    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);

        // Play
        playPause = new JButton("Play");
        playPause.addActionListener(actionListener);
        panel.add(playPause, c);

        // Stop
        c.gridx++;
        stopButton = new JButton("Stop");
        stopButton.addActionListener(actionListener);
        panel.add(stopButton, c);

        // Apply
        c.gridy++;
        c.gridx = 0;
        aplly = new JButton("Apply");
        aplly.addActionListener(actionListener);
        panel.add(aplly, c);

        // Reset
        c.gridx++;
        reset = new JButton("Reset");
        reset.addActionListener(actionListener);
        panel.add(reset, c);
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
}