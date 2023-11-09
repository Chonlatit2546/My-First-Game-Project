package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

   WindowGame windowGame;
   JButton jbtStart = new JButton();
   JButton jbtExit = new JButton();

   URL background = this.getClass().getResource("MainMenu_bg.png");
   Image bg = new ImageIcon(background).getImage();

   URL Start = this.getClass().getResource("Start.png");
   Image start = new ImageIcon(Start).getImage();

   URL Exit = this.getClass().getResource("Exit.png");
   Image exit = new ImageIcon(Exit).getImage();

   URL Name = this.getClass().getResource("Name.png");
   Image name = new ImageIcon(Name).getImage();

   public MainMenu(WindowGame windowGame) {

      this.windowGame = windowGame;

      setPreferredSize(new Dimension(1700, 800));
      setLayout(null);

      jbtStart.setBounds(500, 600, 200, 100);
      jbtExit.setBounds(1000, 600, 200, 100);
      
      jbtStart.setIcon(new ImageIcon(start));
      jbtExit.setIcon(new ImageIcon(exit));

      jbtStart.addActionListener(new StartGame());
      jbtExit.addActionListener(new ExitGame());
      add(jbtStart);
      add(jbtExit);
   }

   @Override
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
      
   }

   class StartGame implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         
         windowGame.setCurrentPanel(new Mypanel(windowGame));
         
      }
   }

   class ExitGame implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }

   }
}
