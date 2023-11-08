package main;

public class Game {
   public WindowGame windowGame;
   private Mypanel mypanel;
   private MainMenu mainMenu;

   public Game(){
      //mypanel = new Mypanel();
      //windowGame = new WindowGame(mypanel);
      //mainMenu = new MainMenu(windowGame);
      //mypanel.setFocusable(true);
      //mypanel.requestFocus();

      // mainMenu = new MainMenu(windowGame);
       windowGame = new WindowGame();
   }
   
}
