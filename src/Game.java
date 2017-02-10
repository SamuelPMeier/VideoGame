/************************************************************************
 * File: 
 * Desc:
 * -----------------------------------------------------------------
 * Author: Sam Meier
 * Date: 02/10/2017
 */

/*
 * Game.java
 * 
 *    Main game loop for controlling the major backbone of the game
 * this includes the timers for rendering and updates
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{

   // variable pool
   public static final int WIDTH = 1300, HEIGHT = WIDTH / 16 * 9;
   private Thread thread;
   private boolean running = false;
   private Handeler handle; // all game objecs

   public Game() throws IOException{
      handle = new Handeler(); // initilize new handler
      this.addKeyListener(new KeyInput(handle)); // begin listening for key inputs
      new Window(WIDTH, HEIGHT, "Game", this); // generate new window
      handle.add(new Boarder(handle)); // add the new boader, this will be grey
      handle.add(new Player(250,200, handle)); // create the player and HUD graphics
      handle.add(new Hud(0,0,handle));
      start();
   }

   // this happens at the same time as
   public synchronized void start(){
      // reserve a thread for this Java programs use
      thread = new Thread(this);
      thread.start();
      running = true;
   }

   public synchronized void stop(){
      try{
         thread.join();
      }catch(Exception e){
         e.printStackTrace();
      }
   }

   // Main loop for game, handles when objecs are rendered and when
   public void run() {

      // Longs for timers
      long lastTime = System.nanoTime();
      long timer = System.currentTimeMillis();
      
      // doubles else
      double APS = 60.0; // actions per second
      double ns = 1000000000 / APS;
      double delta = 0;
      while(running){
         long now = System.nanoTime(); // current time in Nano seconds
         delta += (now - lastTime) / ns; // delta will only be above 1 60 times a second
         lastTime = now;
         // this loop limits the amount of times game objects update persecond
         // with FPS set 60.0, the game objects will only update information 60 
         // times a second
         while(delta >= 1){
            tick();
            delta--;
         }
         // untie rendering from FPS, therefore, unlimited FPS, but game engine
         // is not tied to when objects render.
         if(running)
            render();
         // make sure timer stays within 1 second
         if(System.currentTimeMillis() - timer > 1000){
            timer += 1000;
         }
         if(Player.HP <= 0) GameOver();
      }
      stop();
   }

   // update all game objecs
   private void tick(){
      handle.tick();
   }

   // render all game objecs
   private void render(){
      // help allocate complex memory with graphics, aka
      // helps render game in a smoother manner.
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null){
         this.createBufferStrategy(3);
         return;
      }
      
      // create new graphics using buffer stratagy to help rendering go smoothly
      Graphics g = bs.getDrawGraphics(); 
      
      // this is the main window
      g.setColor(Color.black);
      g.fillRect(0, 0, WIDTH, HEIGHT);

      handle.render(g); // render current game scene
      g.dispose(); // get rid of old data
      bs.show(); // show graphics on screen
   }

   // game over screen
   public void GameOver(){
      handle.OList.clear(); // remove all other objecs, except the main window
      handle.OList.add(new GameOverScreen(270,160, handle)); // print game over screen.
   }

   // start main loop
   public static void main(String arge[]) throws IOException{
      new Game();
   }
}
