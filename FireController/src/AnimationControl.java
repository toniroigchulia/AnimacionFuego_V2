import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AnimationControl extends JPanel {

    // ATRIBUTOS

    private JButton playPause;
    private JButton reset;
    private JButton aplly;
    private JButton stopButton;
    private JButton imageButton;

    private ActionListener actionListener;

    // CONSTRUCTOR

    public AnimationControl(ActionListener actionListener) {
        this.actionListener = actionListener;

        // Create an outer panel for setting the border
        JPanel outerPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        outerPanel.setBorder(border);

        // Create the inner panel with GridBagLayout
        this.setLayout(new GridBagLayout());
        addButtonsToPane(this);

        // Add the inner panel to the outer panel
        outerPanel.add(this);

        // Set this AnimationControl to the outer panel
        this.removeAll();  // Remove existing components
        this.setLayout(new GridBagLayout());
        this.add(outerPanel);
    }

    // METODOS

    // Grid de los botones
    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        this.setBorder(border);
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);

        // Play
        this.playPause = new JButton("Play");
        this.playPause.addActionListener(actionListener);
        panel.add(this.playPause, c);

        // Stop
        c.gridy = 2;
        stopButton = new JButton("Stop");
        stopButton.addActionListener(actionListener);
        panel.add(stopButton, c);

        // Apply
        c.gridy = 3;
        aplly = new JButton("Apply");
        aplly.addActionListener(actionListener);
        panel.add(aplly, c);

        // Reset
        c.gridy = 4;
        reset = new JButton("Reset");
        reset.addActionListener(actionListener);
        panel.add(reset, c);

        // ImageButton
        c.gridy = 5;
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
}
