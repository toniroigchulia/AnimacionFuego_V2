import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FireView extends JFrame {

   // ATRIBUTOS

   private Viewer viewer;
   private ControlPanel controlPanel;
   private FireController controller;
   private ActionListener actionListener;
   private Container panel;
   private boolean updated = true;

   // CONSTRUCTORES

   public FireView(FireController controller) {

      this.viewer = new Viewer();
      this.controller = controller;
      actionListener = new Listener();
      configureFrame();

      this.controlPanel = new ControlPanel(panel, actionListener);

      this.viewer.loadBackground(controlPanel.getGeneralParameters().getBackgroundImage());
      this.setSize(1200, 920);
   }

   // METODOS

   // Añadir componenetes a la UI y configurar el frame
   private void addUIComponents() {

      this.panel = this.getContentPane();
      addViewerToPane(panel);
   }

   private void configureFrame() {

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new GridBagLayout());
      this.setVisible(true);
      addUIComponents();
   }

   // Grid para la animacion
   private void addViewerToPane(Container panel) {
      GridBagConstraints c = new GridBagConstraints();

      c.anchor = GridBagConstraints.NORTHWEST;
      c.fill = GridBagConstraints.BOTH;
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.weighty = 1;
      c.gridheight = 50;
      c.gridwidth = 1;

      panel.add(this.viewer, c);
   }

   // GETTERS AND SETTERS

   public Viewer getViewer() {

      return this.viewer;
   }

   public boolean isUpdated() {
      return updated;
   }

   public void setUpdated(boolean updated) {
      this.updated = updated;
   }

   public ControlPanel getControlPanel() {

      return this.controlPanel;
   }

   // LISTENER

   private class Listener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         String str = e.getActionCommand();
         switch (str) {
            // Empezar la animacion
            case "Play":

               controller.setAnimation(true);
               controlPanel.getAnimationControl().getAplly().setEnabled(false);
               break;

            // Parar la animacion
            case "Stop":

               controller.setAnimation(false);
               controlPanel.getAnimationControl().getAplly().setEnabled(true);
               break;
            // Resetear los parametors a los default
            case "Reset":

               controller.setAnimation(false);
               controlPanel.setGeneralParameters(new DTOGeneralParameters());
               controlPanel.setTemperatureParameters(new DTOTemperatureParameters());
               
               controlPanel.getAnimationControl().getAplly().setEnabled(true);
               
               // Poner el background Default
               controlPanel.setDefaultBackgroundImage();
               viewer.loadBackground(controlPanel.getGeneralParameters().getBackgroundImage());

               controlPanel.getGeneralConfiguration().resetValues();
               controlPanel.getTemperatureConfiguration().defaultValues();
               updated = true;
               break;
            // Aplicar los cambios
            case "Apply":

                  controlPanel.getGeneralParameters().setFireHight(controlPanel.getGeneralConfiguration().getHeigh());
                  controlPanel.getGeneralParameters().setFireWidth(controlPanel.getGeneralConfiguration().getWidth());
                  controlPanel.getGeneralParameters().setFirXPosition(controlPanel.getGeneralConfiguration().getPosX());
                  controlPanel.getGeneralParameters().setFireYPosition(controlPanel.getGeneralConfiguration().getPosY());

                  controlPanel.getTemperatureParameters().setBottonUpTemps(controlPanel.getTemperatureConfiguration().bottomUpTemps());
                  controlPanel.getTemperatureParameters().setNewCoolPixelsPercentage(controlPanel.getTemperatureConfiguration().getNewCoolPixelsPercentage());
                  controlPanel.getTemperatureParameters().setNewHotPixelsPercentage(controlPanel.getTemperatureConfiguration().getNewHotPixelsPercentage());
                  controlPanel.getTemperatureParameters().setCellsDivider(controlPanel.getTemperatureConfiguration().getCellsDivider());
                  controlPanel.getTemperatureParameters().setCellsPonderation(controlPanel.getTemperatureConfiguration().getCellsPonderation());
                  controlPanel.getTemperatureParameters().setFixAtenuationFactor(controlPanel.getTemperatureConfiguration().getFixAtenuationFactor());

               updated = true;
               break;
            // Cambiar el Background
            case "Change Background":
               JFileChooser fileChooser = new JFileChooser();
               FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Filtro", "jpg", "jpeg", "png", "gif",
                     "bmp");
               fileChooser.setFileFilter(fileFilter);

               BufferedImage selectedImage;
               int returnValue = fileChooser.showOpenDialog(null);

               if (returnValue == JFileChooser.APPROVE_OPTION) {
                  File selectedFile = fileChooser.getSelectedFile();

                  try {
                     selectedImage = ImageIO.read(selectedFile);
                     controlPanel.getGeneralParameters().setBackgroundImage(selectedImage);
                     controlPanel.getGeneralConfiguration().setImageParameters(selectedFile.getName(),
                           selectedFile.getParentFile().getName(), selectedImage.getWidth(), selectedImage.getHeight());
                  } catch (IOException ex) {
                  }
               }
               viewer.loadBackground(controlPanel.getGeneralParameters().getBackgroundImage());
               updated = true;
               break;
            default:
               System.out.println("Opcion no valida");
         }
      }
   }
}
