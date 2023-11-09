package main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import Entity.Bird;
import Entity.Entity;
import Entity.Human;
import Entity.Player;
import Input.KeyboardInput;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Mypanel extends JPanel implements Runnable {

   // Game
   KeyboardInput kInput;
   int FPS = 144;
   Thread gameThread;
   public CollisionChek cCheck;
   public List<Entity> entities;
   private long startTime = System.currentTimeMillis();;  // เวลาเริ่มต้นเกม
   private long elapsedTime = System.currentTimeMillis() - startTime; 
   public int Amout_dead = 0;

   public int Point = 0;
   int fontSize = 24;
   Font font = new Font("Arial", Font.PLAIN, fontSize);
   // Player
   Player player;

   // Human
   Human human;
   Human human1 = new Human(this);
   Human human2 = new Human(this);
   Human human3 = new Human(this);
   Human human4 = new Human(this);
   Human human5 = new Human(this);

   // Bird
   Bird bird;

   // Background
   URL background = this.getClass().getResource("bg.png");
   Image bg = new ImageIcon(background).getImage();

   WindowGame windowGame;

   public Mypanel() {

      setPreferredSize(new Dimension(1700, 800));

      kInput = new KeyboardInput();
      addKeyListener(kInput);
      this.setFocusable(true);

      entities = new ArrayList<>();

      player = new Player(this, kInput);

      human = new Human(this);
      //human1 = new Human(this);
      human1.y = 300;
      human1.hitbox_y = human1.y + 70;

      human2.y = 600;
      human2.x = 200;
      human2.hitbox_x = human2.x + 30;
      human2.hitbox_y = human2.y + 70;

      human3.y = 500;
      human3.x = 500;
      human3.direction = "left";
      human3.hitbox_x = human3.x + 30;
      human3.hitbox_y = human3.y + 70;

      human4.y = 210;
      human4.x = 300;
      human4.direction = "left";
      human4.hitbox_x = human4.x + 30;
      human4.hitbox_y = human4.y + 70;

      human5.y = 360;
      human5.x = 700;
      human5.direction = "left";
      human5.hitbox_x = human5.x + 30;
      human5.hitbox_y = human5.y + 70;

      bird = new Bird(this);

      entities.add(player);
      entities.add(human);
      entities.add(human1);
      entities.add(human2);
      entities.add(human3);
      entities.add(human4);
      entities.add(human5);

      cCheck = new CollisionChek(this, entities);

   }

   public Mypanel(WindowGame windowGame){
      this();
      this.windowGame =windowGame;
   }

   public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
   }

   @Override
   public void run() {

      double drawInterval = 1000000000 / FPS;
      double delta = 0;
      long currentTime;
      long lastTime = System.nanoTime();

      while (gameThread != null) {

         currentTime = System.nanoTime();

         delta += (currentTime - lastTime) / drawInterval;

         lastTime = currentTime;

         if (delta >= 1) {

            update();
            repaint();
            delta--;
         }

      }
   }

   public void update() {
      player.update();
      
      for(Entity e : entities){
         cCheck.Check(e);

         
      }

      long currentTime = System.currentTimeMillis();
      elapsedTime = (60000 - (currentTime - startTime))/1000;
      

      if(elapsedTime == 0 || Amout_dead == 6){

         try{
            
            showScore s = new showScore(windowGame,this);
            windowGame.setCurrentPanel(s);
            gameThread.sleep(currentTime);
         }
         catch(Exception e){
            
         }
         
            
      }
   }

 

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

      g.setFont(font);
      g.drawString("Your point : "+ String.valueOf(Point), 30,20);
      g.drawString("Time :" + String.valueOf(elapsedTime), 30,40);

      human.draw(g);
      human1.draw(g);
      human2.draw(g);
      human3.draw(g);
      human4.draw(g);
      human5.draw(g);

      player.draw(g);
      bird.draw(g);
      
   }

}
