import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
   private boolean updated = true;

   // CONSTRUCTORES

   public FireView(FireController controller) {

      this.controller = controller;
      this.viewer = new Viewer();
      actionListener = new Listener();
      this.controlPanel = new ControlPanel(actionListener);
      configureFrame();


      this.viewer.loadBackground(controlPanel.getGeneralParameters().getBackgroundImage());
      this.setSize(1150, 900);
      // this.setResizable(false);
   }

   // METODOS

   // Añadir componenetes a la UI y configurar el frame
   private void addUIComponents() {
      GridBagConstraints c = new GridBagConstraints();
      c.insets = new Insets(5, 5, 5, 5);
      c.anchor = GridBagConstraints.WEST;
      c.fill = GridBagConstraints.BOTH;

      c.gridx = 0;
      c.gridy = 0;
      add(controlPanel, c);

      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      add(viewer, c);
   }

   private void configureFrame() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new GridBagLayout());
      this.setVisible(true);
      addUIComponents();
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

               // controlPanel.getGeneralConfiguration().resetValues();
               controlPanel.getTemperatureConfiguration().defaultValues();
               updated = true;
               break;
            // Aplicar los cambios
            case "Apply":

               // Configuracion general
               controlPanel.getGeneralParameters().setFireHight(controlPanel.getGeneralConfiguration().getFireHeigh());
               controlPanel.getGeneralParameters().setFireWidth(controlPanel.getGeneralConfiguration().getFireWidth());
               controlPanel.getGeneralParameters().setFirXPosition(controlPanel.getGeneralConfiguration().getFirePosX());
               controlPanel.getGeneralParameters().setFireYPosition(controlPanel.getGeneralConfiguration().getFirePosY());

               // Configuracion del calculo del fuego
               controlPanel.getTemperatureParameters()
                     .setBottonUpTemps(controlPanel.getTemperatureConfiguration().bottomUpTemps());
               controlPanel.getTemperatureParameters().setNewCoolPixelsPercentage(
                     controlPanel.getTemperatureConfiguration().getNewCoolPixelsPercentage());
               controlPanel.getTemperatureParameters()
                     .setNewHotPixelsPercentage(controlPanel.getTemperatureConfiguration().getNewHotPixelsPercentage());
               controlPanel.getTemperatureParameters()
                     .setCellsDivider(controlPanel.getTemperatureConfiguration().getCellsDivider());
               controlPanel.getTemperatureParameters()
                     .setCellsPonderation(controlPanel.getTemperatureConfiguration().getCellsPonderation());
               controlPanel.getTemperatureParameters()
                     .setFixAtenuationFactor(controlPanel.getTemperatureConfiguration().getFixAtenuationFactor());
               controlPanel.getTemperatureParameters().setBottonUpTemps(controlPanel.getTemperatureConfiguration().bottomUpTemps());
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
