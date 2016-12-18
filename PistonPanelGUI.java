package Undergraduate_Project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;


public class PistonPanelGUI extends JPanel {

   // object declarations
   private JLabel piston;
   private ImageIcon piston_25;
   
   private static final int IMG_X_POS = 36;
   private static final int IMG_WIDTH = 119;
   private static final int IMG_HEIGHT = 701;
   private int IMG_Y_POS = 0;
   
   //public MainDisplay md = new MainDisplay();
   
   
   // default constructor
   public PistonPanelGUI() {
      
      // initialize objects
      piston = new JLabel();
      piston_25 = new ImageIcon(getClass().getResource("/resources/piston25.png"));
      
      
      // set up panel
      setupPistonPanel();
   }
   
   // sets up beginning display of the piston panel
   private void setupPistonPanel() {

      // default settings
      this.setBackground(Color.WHITE);
      this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
      this.setBounds(12,13,192,695);
      setLayout(null);
      this.add(piston);
//		setPiston0();
      setPistonX(1);
   }
   
   
   
   public void piston_rep(double x, Object piston) throws InterruptedException {
      
//		System.out.println(x);
      //At floor 1
      if (x == 0.0) {
         this.setPistonX(1);
      } 

      //Move to 2nd floor
      else if (x > 0.1 && x < 9.9) {
         this.setPistonX(540, 420, piston);
      } 
      
      //At floor 2
      else if (x == 10) {
         this.setPistonX(2);
      } 
      
      //Move to 3nd floor
      else if (x > 10.1 && x < 19.9) {
         this.setPistonX(420, 280, piston);
      } 
      
      //At floor 3
      else if (x == 20) {
         this.setPistonX(3);
      } 
      
      //Move to 4nd floor
      else if (x > 20.1 && x < 29.9) {
         this.setPistonX(280, 140, piston);
      } 
      
      //At floor 4
      else if (x == 30) {
         this.setPistonX(4);
      } 
      
      //Moving to floor 5
      else if (x > 30.1 && x < 39.9) {
         this.setPistonX(140, 0, piston);
      } 
      
      //At floor 5
      else if (x == 40) {
         this.setPistonX(5);
      }
   }
   
   
   public void setPistonX(int f){
      piston.setIcon(piston_25);
      if (f == 1){
         setImgPos(IMG_X_POS,(IMG_Y_POS+540),IMG_WIDTH,IMG_HEIGHT);
      } else if ( f == 2) {
         setImgPos(IMG_X_POS,(IMG_Y_POS+420),IMG_WIDTH,IMG_HEIGHT);
      } else if ( f == 3) {
         setImgPos(IMG_X_POS,(IMG_Y_POS+280),IMG_WIDTH,IMG_HEIGHT);
      } else if ( f == 4) {
         setImgPos(IMG_X_POS,(IMG_Y_POS+140),IMG_WIDTH,IMG_HEIGHT);
      } else if ( f == 5) {
         setImgPos(IMG_X_POS,(IMG_Y_POS+0),IMG_WIDTH,IMG_HEIGHT);
      }

   }
   
   
   public void setPistonX(int x1, int x2, Object pistonDirection) throws InterruptedException {
      piston.setIcon(piston_25);
      
      int highX = x1;
      int lowX = x2;

      System.out.println("[+] " + pistonDirection);
      System.out.print("[up?] " + (pistonDirection == Piston.MOVING_UP));
      System.out.print("\t[do?] " + (pistonDirection == Piston.MOVING_DOWN + "\n"));
      
      
      // Piston moving UP! -> Decrease X position to go up! 
      if (pistonDirection == Piston.MOVING_UP) {
         for (int i = highX; i > lowX; i--) {
            Thread.sleep(1);
            
            setImgPos(IMG_X_POS,(IMG_Y_POS+i),IMG_WIDTH,IMG_HEIGHT);
            System.out.println("Image x: " + (IMG_Y_POS+i) + ".");
            System.out.println(pistonDirection);

         }
      } 
      
      // Piston movind Down! -> Increase X position to go down!
      // initialX is always the high position 
      // e.g. we are going from 0 -> 100 

      else if (pistonDirection == Piston.MOVING_DOWN) {
         for (int i = lowX; i < highX; i++) {
            
            Thread.sleep(1);
            
            setImgPos(IMG_X_POS,(IMG_Y_POS+i),IMG_WIDTH,IMG_HEIGHT);
            System.out.println("Image x: " + (IMG_Y_POS+i) + ".");
            System.out.println(pistonDirection);
         }
      }
      
      else {
         System.out.println("[*] Error PistonPanelGUI.setPistonX();");
      }
   }
   
   public int getImgYPos() {
      return piston.getY();
   } 
   
   public void setImgYPos(int y) {
      IMG_Y_POS = y;
   }
   
   public void setImgPos(int x, int y, int w, int h) {
      piston.setBounds(x,y,w,h);
   }
}