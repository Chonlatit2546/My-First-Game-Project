package Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import main.Mypanel;


public class Bird extends Entity {

   Mypanel mypanel;

   URL birdImage = this.getClass().getResource("bird.png");
   URL bird2Image = this.getClass().getResource("birdAnimation.png");
   Image bird[];

   Timer birdAni_Timer = new Timer(200, new birdAnimation());

   public Bird(Mypanel mypanel) {

      this.mypanel = mypanel;

      x = mypanel.getWidth();
      y = 100;
      speed = -20;
      Ani = 0;

      bird = new Image[2];
      bird[0] = new ImageIcon(birdImage).getImage();
      bird[1] = new ImageIcon(bird2Image).getImage();
      
      birdAni_Timer.start();

   }

   public void draw(Graphics g) {
      g.drawImage(bird[Ani], x, y, 100, 100, null);
      g.drawImage(bird[Ani], x + 30, y - 30, 100, 100, null);
      g.drawImage(bird[Ani], x + 30, y + 30, 100, 100, null);
   }

   public void update() {
      Ani++;

      if (Ani > 1) {
         Ani = 0;
      }

      x += speed;

      if (x < 0)
         x = mypanel.getWidth();
   }

   class birdAnimation implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         update();
      }

   }
}
