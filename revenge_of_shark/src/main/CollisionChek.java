package main;

import java.util.List;
import java.awt.Rectangle;

import Entity.Entity;
import Entity.Human;
import Entity.Player;

public class CollisionChek {

   Mypanel mypanel;
   List<Entity> entities;

   public CollisionChek(Mypanel mypanel, List<Entity> entities) {
      this.mypanel = mypanel;
      this.entities = entities;
   }

   public void Check(Entity entity) {

      for (Entity other : entities) {

         if (entity instanceof Human) {

            if (((Human) entity).x < 0) {

               ((Human) entity).x = 1700;
               ((Human) entity).direction = "left";
               // ((Human)entity).direction = "right";

            }

            if (((Human) entity).x > 1700) {
               ((Human) entity).x = 1;
               ((Human) entity).direction = "right";
               // ((Human)entity).direction = "left";

            }

            if (other instanceof Player) {

               Entity h = (Human) entity;
               Entity p = (Player) other;

               if (p.hitbox_x - (h.hitbox_x + h.hitbox_Width) < 200 && p.hitbox_x - (h.hitbox_x + h.hitbox_Width) > -1
                     && h.direction == "right") {
                  h.direction = "left";
               } else if (h.hitbox_x - (p.hitbox_x + p.hitbox_Width) < 200
                     && h.hitbox_x - (p.hitbox_x + p.hitbox_Width) > -1 && h.direction == "left") {
                  h.direction = "right";
               }
            }

         }

         if (entity.Hitbox.intersects(other.Hitbox)) {

            if (entity instanceof Player && other instanceof Human) {

               Player player = (Player) entity;
               Human human = (Human) other;

               if (mypanel.kInput.spacePressed == true) {
                  
                  if (human.direction == "left") {
                     human.direction = "bleed_left";
                     mypanel.Point += 100;
                     mypanel.Amout_dead++;
                  } else if (human.direction == "right") {
                     human.direction = "bleed_right";
                     mypanel.Point += 100;
                     mypanel.Amout_dead++;
                  }
                  // human.x = 2000;
                  // human.y = 2000;
                  // human.humanAni_Timer.stop();
                  human.human_bleed_Ani.start();
                  // human.human_bleed_Ani.setRepeats(false);
               }

               Rectangle playerBounds = new Rectangle(player.hitbox_x, player.hitbox_y, player.hitbox_Width,
                     player.hitbox_Height);
               Rectangle humanBounds = new Rectangle(human.hitbox_x, human.hitbox_y, human.hitbox_Width,
                     human.hitbox_Height);

               if (playerBounds.intersects(humanBounds)) {
                  if ((player.direction == "right" && other.direction == "right")) {
                     if (player.x < human.x) {
                        player.x = player.previus_x;
                        player.y = player.previus_y;
                     }

                     if (player.x > human.x) {
                        player.x = player.x + 2;
                        player.hitbox_x = player.hitbox_x + 2;
                        player.y = player.previus_y;
                     }

                  } else if ((player.direction == "left" && other.direction == "left")) {

                     if (player.x < human.x) {
                        player.x = player.x - 2;
                        player.hitbox_x = player.hitbox_x - 2;
                        player.y = player.previus_y;

                     }

                     if (player.x > human.x) {
                        player.x = player.previus_x;
                        player.y = player.previus_y;
                     }

                     if (player.hitbox_x <= 0) {
                        player.hitbox_x = player.x;
                        player.y = player.previus_y;
                     }
                  } else if (player.direction == "right" && other.direction == "left") {

                     if (player.x < human.x) {
                        player.x = player.x - 2;
                        player.hitbox_x = player.hitbox_x - 2;
                        player.y = player.previus_y;
                     }

                     if (player.hitbox_x <= 0) {
                        player.hitbox_x = player.x;
                        player.y = player.previus_y;
                     }

                  } else if (player.direction == "left" && other.direction == "right") {
                     if (player.x > other.x) {
                        player.x = player.x + 2;
                        player.hitbox_x = player.hitbox_x + 2;
                        player.y = player.previus_y;
                     }

                     player.y = player.previus_y;
                  }

               }
            }

         }

      }
   }
}
