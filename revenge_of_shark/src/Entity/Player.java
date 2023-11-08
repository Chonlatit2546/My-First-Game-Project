package Entity;

import main.Mypanel;
import Input.KeyboardInput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player extends Entity {

   Mypanel mypanel;
   KeyboardInput kInput;

   Timer SharkAni_timer = new Timer(250, new sharkAnimation());
   Timer close_Mouth = new Timer(1000, new Close_Mouth());

   URL newSh = this.getClass().getResource("Shark.png");
   URL newSh2 = this.getClass().getResource("Shark2.png");

   URL sharkAni1 = this.getClass().getResource("SharkAni1.png");
   URL sharkAni2 = this.getClass().getResource("SharkAni2.png");
   URL sharkAni3 = this.getClass().getResource("SharkAni3.png");
   URL shark_turnleft = this.getClass().getResource("turnleft_shark.png");
   URL shark_leftAni1 = this.getClass().getResource("shark_leftAni1.png");
   URL shark_leftAni2 = this.getClass().getResource("shark_leftAni2.png");
   URL shark_leftAni3 = this.getClass().getResource("shark_leftAni3.png");
   URL shark_leftBite = this.getClass().getResource("shark_leftBite.png");

   Image Shark[];
   Image Shark_turnleft[];

   // public int hitbox_x = x + 20;
   // public int hitbox_y = y + 60;
   // public int hitbox_Width = 150;
   // public int hitbox_Height = 60;

   public int previus_x;
   public int previus_y;

   public String direction_y = "down";

   public Player(Mypanel mypanel, KeyboardInput key_Input) {

      x = 100;
      y = 400;
      width = 200;
      height = 200;
      speed = 3;
      Ani = 0; // for change animation

      previus_x = x;
      previus_y = y;

      // hitbox_x = this.x+20;
      // hitbox_y = this.y+60;
      // hitbox_Width = this.width-50;
      // hitbox_Height = this.height-150;

      hitbox_x = this.x+20;
      hitbox_y = this.y+60;
      hitbox_Width = this.width-60;
      hitbox_Height = this.height-150;

      // System.out.println("shark" + hitbox_x);
      // System.out.println("shark" + hitbox_y);
      // System.out.println("shark" + hitbox_Width);
      // System.out.println("shark" + hitbox_Height);
      direction = "right";
      

      this.mypanel = mypanel;
      this.kInput = key_Input;

      //Hitbox = new Rectangle(x+20, y+60, hitbox_Width, hitbox_Height);
      Hitbox = new Rectangle(hitbox_x, hitbox_y, hitbox_Width, hitbox_Height);

      Shark = new Image[5];
      Shark_turnleft = new Image[5];
      Shark[0] = new ImageIcon(newSh).getImage();
      Shark[1] = new ImageIcon(sharkAni1).getImage();
      Shark[2] = new ImageIcon(sharkAni2).getImage();
      Shark[3] = new ImageIcon(sharkAni3).getImage();
      Shark[4] = new ImageIcon(newSh2).getImage();

      Shark_turnleft[0] = new ImageIcon(shark_turnleft).getImage();
      Shark_turnleft[1] = new ImageIcon(shark_leftAni1).getImage();
      Shark_turnleft[2] = new ImageIcon(shark_leftAni2).getImage();
      Shark_turnleft[3] = new ImageIcon(shark_leftAni3).getImage();
      Shark_turnleft[4] = new ImageIcon(shark_leftBite).getImage();

      SharkAni_timer.start();
   }

   public void setDefualtValues() {

      x = 100;
      y = 400;
      speed = 3;
   }

   public void update() {
      previus_x = x;
      previus_y = y;
      if (kInput.upPressed == true) {
         y -= speed;
         hitbox_y = this.y+60;
         direction_y = "up";
      } else if (kInput.downPressed == true) {
         y += speed;
         hitbox_y = this.y+60;
         direction_y = "down";
      } else if (kInput.leftPressed == true) {
         x -= speed;
         hitbox_x = this.x+20;
         direction = "left";
      } else if (kInput.rightPressed == true) {
         x += speed;
         hitbox_x = this.x+20;
         direction = "right";
      } else if (kInput.spacePressed == true) {
         Bite();
      }

      // System.out.println(y);
      if (y <= 205) {
         y = 205;
      }
      if (y >= 625) {
         y = 625;
      }
      if (x <= 0) {
         x = 0;
      }
      if (x >= 1500) {
         x = 1500;
      }
      //Hitbox.setBounds(x + 20, y + 60, hitbox_Width, hitbox_Height);
      
      Hitbox.setBounds(hitbox_x, hitbox_y, hitbox_Width, hitbox_Height);
      mypanel.cCheck.Check(this);
   }

   public void draw(Graphics g) {

      //g.setColor(Color.PINK);
      //g.drawRect(x+20, y+60, 150, 60);
      //g.drawRect(hitbox_x, hitbox_y, hitbox_Width, hitbox_Height);

      if (direction == "right")
         g.drawImage(Shark[Ani], x, y, width, height, null);
      else if (direction == "left")
         g.drawImage(Shark_turnleft[Ani], x, y, height, width, null);
   }

   class sharkAnimation implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         Ani++;

         if (Ani == 3)
            Ani = 0;
      }
   }

   void Bite() {

      Ani = 4;
      SharkAni_timer.stop();
      close_Mouth.start();
   }

   class Close_Mouth implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         if (Ani == 4)
            Ani = 0;

         SharkAni_timer.restart();
      }
   }
}
