package Input;

import java.awt.event.*;


public class KeyboardInput implements KeyListener{

   public boolean upPressed,downPressed,leftPressed,rightPressed,spacePressed;
   

   @Override
   public void keyTyped(KeyEvent e) {
      
   }

   @Override
   public void keyPressed(KeyEvent e){
      switch(e.getKeyCode()){
         case KeyEvent.VK_W :
         upPressed = true;
         System.out.println("W is press!");
         break; 
         case KeyEvent.VK_A :
         leftPressed = true;
         System.out.println("A is press!");
         break; 
         case KeyEvent.VK_S :
         downPressed = true;
         System.out.println("S is press!");
         break;
         case KeyEvent.VK_D :
         rightPressed = true;
         System.out.println("D is press!");
         break; 
         case KeyEvent.VK_SPACE:
         spacePressed = true;
         System.out.println("space is press!");
         break;
         
      }
     
   }

   @Override
   public void keyReleased(KeyEvent e) {
      switch(e.getKeyCode()){
         case KeyEvent.VK_W :
         upPressed = false;
         System.out.println("W is press!");
         break; 
         case KeyEvent.VK_A :
         leftPressed = false;
         System.out.println("A is press!");
         break; 
         case KeyEvent.VK_S :
         downPressed = false;
         System.out.println("S is press!");
         break;
         case KeyEvent.VK_D :
         rightPressed = false;
         System.out.println("D is press!");
         break; 
         case KeyEvent.VK_SPACE:
         spacePressed = false;
         System.out.println("space is press!");
         break;
      }
   }
   
}
