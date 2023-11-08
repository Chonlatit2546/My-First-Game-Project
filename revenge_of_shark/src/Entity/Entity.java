package Entity;

import java.awt.Rectangle;

public class Entity {

   public int x, y;
   public int width,height;
   public int Ani;
   public int speed;

   public String direction;
   //public String direction_y;

   public Rectangle Hitbox;
   

   public int hitbox_x;
   public int hitbox_y;
   public int hitbox_Width;
   public int hitbox_Height;

   public boolean collisionOn = false;

   public void updateHitbox_x(int x){
      hitbox_x = x;
   }
   
   public void updateHitbox_y(int y){
      hitbox_y = y;
   }
}
