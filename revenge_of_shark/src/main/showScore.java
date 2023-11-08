package main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showScore extends JPanel{
      
   URL background = this.getClass().getResource("ShowScore_bg.png");
   Image bg = new ImageIcon(background).getImage();

   URL TryAgain = this.getClass().getResource("TryAgain.png");
   Image tryagain = new ImageIcon(TryAgain).getImage();

   URL BackToMenu = this.getClass().getResource("BackToMenu.png");
   Image backtomenu = new ImageIcon(BackToMenu).getImage();

   JButton jbtTryagain = new JButton();
   JButton jbtMenu = new JButton();

   WindowGame windowGame;
   Mypanel mypanel;

   int fontSize = 100;
   Font font = new Font("Arial", Font.PLAIN, fontSize);

   public showScore(WindowGame windowGame,Mypanel mypanel){

      this.windowGame = windowGame;
      this.mypanel = mypanel;

      setPreferredSize(new Dimension(1700, 800));
      setLayout(null);

      //ImageIcon start = new ImageIcon(start);
      
      jbtTryagain.setBounds(500, 600, 200, 100);
      jbtMenu.setBounds(1000, 600, 200, 100);
      
      //jbtStart.setPreferredSize(new Dimension(200,100));
      jbtTryagain.setIcon(new ImageIcon(tryagain));
      jbtMenu.setIcon(new ImageIcon(backtomenu));

      jbtMenu.addActionListener(new BackToMain());
      jbtTryagain.addActionListener(new TryAgain());

      add(jbtTryagain);
      add(jbtMenu);
   }

   @Override
   public void paintComponent(Graphics g){

      g.drawImage(bg, 0, 0, getWidth(),getHeight(),null);

      g.setFont(font);
      g.drawString(String.valueOf(mypanel.Point),1100 , 250);
   }

   class BackToMain implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         windowGame.setCurrentPanel(new MainMenu(windowGame));
      }

   }

   class TryAgain implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         windowGame.setCurrentPanel(new Mypanel(windowGame));
      }


   }
}
