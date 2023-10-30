import javax.swing.JFrame;
import static java.lang.Thread.sleep;

public class FireController extends JFrame {

   // MAIN
   public static void main(String[] args) throws Exception {

      FireController fc = new FireController();
      fc.playAnimation();
   }

   // ATRIBUTOS

   private FireModel fireModel;
   private FireView fireView;
   private boolean animation = false;

   // CONSTRUCTOR

   public FireController() {

      initClass();
   }

   // METODOS

   // Bucle principal para la animacion
   public void playAnimation() {

      while (true) {

         if (animation) {

            if (this.fireView.isUpdated() == true) {

               this.updateFireModel();
               this.fireView.setUpdated(false);
            }

            this.fireView.getViewer().paintFire(this.fireModel);
         }
         try {
            sleep(50);
         } catch (Exception ex) {
            System.err.println(ex);
         }
      }
   }

   // Si hay cambios en el modelo se llama a este metodo
   public void updateFireModel() {

      this.fireModel = new FireModel(fireView.getControlPanel().getfModelParameters());
   }

   // Metodo para iniciar la classe
   private void initClass() {

      this.fireView = new FireView(this);
      updateFireModel();
   }

   // Metodo para indicar si se tiene que ejecutar la animacion o no
   public void setAnimation(Boolean animation) {

      this.animation = animation;
   }
}
