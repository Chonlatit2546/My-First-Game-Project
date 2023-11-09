package Entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import main.Mypanel;

public class Human extends Entity {

   Mypanel mypanel;

   public Timer humanAni_Timer = new Timer(200, new humanAnimation());

   URL humanImage = this.getClass().getResource("human.png");
   URL humanAni_Image = this.getClass().getResource("humanAni.png");
   Image human[];

   URL humanImage_left1 = this.getClass().getResource("human_left1.png");
   URL humanImage_left2 = this.getClass().getResource("human_left2.png");
   Image human_left[];

   URL human_bleed1 = this.getClass().getResource("human_bleed1.png");
   URL human_bleed2 = this.getClass().getResource("human_bleed2.png");
   URL human_bleed3 = this.getClass().getResource("human_bleed3.png");
   Image human_bleed[];

   URL human_bleed_left1 = this.getClass().getResource("human_bleed_left1.png");
   URL human_bleed_left2 = this.getClass().getResource("human_bleed_left2.png");
   URL human_bleed_left3 = this.getClass().getResource("human_bleed_left3.png");
   Image human_bleed_left[];

   int Ani_bleed = 0;
   public Timer human_bleed_Ani = new Timer(500, new BleedAni());
   

   public int previus_x;
   public int previus_y;

   public boolean dead = false;

   public Human(Mypanel mypanel) {

      this.mypanel = mypanel;

      x = 1000;
      y = 400;
      speed = 10;
      Ani = 0;

      direction = "right";

      hitbox_x = x + 30;
      hitbox_y = y + 70;
      hitbox_Width = 100;
      hitbox_Height = 40;

      Hitbox = new Rectangle(hitbox_x, hitbox_y, hitbox_Width, hitbox_Height);

      human = new Image[2];
      human[0] = new ImageIcon(humanImage).getImage();
      human[1] = new ImageIcon(humanAni_Image).getImage();

      human_left = new Image[2];
      human_left[0] = new ImageIcon(humanImage_left1).getImage();
      human_left[1] = new ImageIcon(humanImage_left2).getImage();

      human_bleed = new Image[3];
      human_bleed[0] = new ImageIcon(human_bleed1).getImage();
      human_bleed[1] = new ImageIcon(human_bleed2).getImage();
      human_bleed[2] = new ImageIcon(human_bleed3).getImage();

      human_bleed_left = new Image[3];
      human_bleed_left[0] = new ImageIcon(human_bleed_left1).getImage();
      human_bleed_left[1] = new ImageIcon(human_bleed_left2).getImage();
      human_bleed_left[2] = new ImageIcon(human_bleed_left3).getImage();

      humanAni_Timer.start();
      
   }

   public void draw(Graphics g) {

      if (direction == "right") {
         g.drawImage(human[Ani], this.x, this.y, 170, 170, null);
      } else if (direction == "left") {
         g.drawImage(human_left[Ani], this.x, this.y, 170, 170, null);
      } else if (direction == "bleed_right") {
         g.drawImage(human_bleed[Ani_bleed], this.x, this.y, 170, 170, null);
      }else if(direction == "bleed_left"){
         g.drawImage(human_bleed_left[Ani_bleed], this.x, this.y, 170, 170, null);
      }

   }

   public void update() {
      Ani++;

      if (Ani > 1)
         Ani = 0;

      if(direction == "right"){
         this.x += this.speed;
         hitbox_x = x + 20;
      }
      if(direction == "left"){
         this.x -= this.speed;
         hitbox_x = x + 20;
      }

      previus_x = x + 1;
      
      Hitbox.setBounds(hitbox_x, hitbox_y, hitbox_Width, hitbox_Height);
      

   }

   class humanAnimation implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         update();
      }

   }

   class BleedAni implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         try {
            
            humanAni_Timer.stop();
                
            Ani_bleed++;

            if (Ani_bleed > 2) {
               direction = "dead";
               Ani_bleed = 0;
            }
         } catch (Exception a){
            humanAni_Timer.stop();
         }

      }

   }

}
