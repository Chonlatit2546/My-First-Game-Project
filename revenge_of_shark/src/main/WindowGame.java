package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowGame extends JFrame{

   JPanel currentPanel ;

   public WindowGame(){
      

      currentPanel = new MainMenu(this);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Revenge of shark");
      setResizable(false);
      add(currentPanel);
      pack();
      setVisible(true);
   }

   public void setCurrentPanel(JPanel newPanel) {
      if (currentPanel != null) {
         remove(currentPanel); // ลบ JPanel ปัจจุบัน
      }

      currentPanel = newPanel;
      add(currentPanel); // เพิ่ม JPanel ใหม่
      pack();
      setLocationRelativeTo(null);
      setVisible(true);

      if (currentPanel instanceof Mypanel) {
         ((Mypanel) currentPanel).setFocusable(true);
         ((Mypanel) currentPanel).requestFocus();
         ((Mypanel) currentPanel).startGameThread(); // เริ่มเธรดเกมเมื่อเปลี่ยนไปใช้ JPanel ของเกม
      }
   }

   public void startGame() {
      getContentPane().removeAll();
      Mypanel mypanel = new Mypanel();
      add(mypanel);
      mypanel.setFocusable(true);
      mypanel.requestFocus();
      mypanel.startGameThread();
   }

}
