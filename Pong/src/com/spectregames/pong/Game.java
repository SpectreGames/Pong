/*
*	Date: Oct 17, 2013
*	Company: Spectre Games
*	Web Address: http://www.spectregames.com
* 
*	Copyright 2013 Phantom Coder(Richard Tester)
* 	Based on code from the following YouTube Channels:
*			BossLetsPlays(Matthew Rogers)
*			RealTutsGML(Zack Berenger)
*
*  	Licensed under the Apache License, Version 2.0 (the "License");
*  	you may not use this file except in compliance with the License.
*  	You may obtain a copy of the License at
*
*	http://www.apache.org/licenses/LICENSE-2.0
*
*  	Unless required by applicable law or agreed to in writing, software
*  	distributed under the License is distributed on an "AS IS" BASIS,
*  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  	See the License for the specific language governing permissions and
*  	limitations under the License.
*/
package com.spectregames.pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.spectregames.pong.enums.GameStates;
import com.spectregames.pong.gfx.Renderer;
import com.spectregames.pong.libs.References;
import com.spectregames.pong.screens.SplashScreen;
import com.spectregames.pong.utils.ResourceLoader;

/**
 * Project Name: Pong
 * Package Name: com.spectregames.pong
 * File Name:    Game.java
 * Class:        Game
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -6515596834996631988L;
	private static JFrame frame= new JFrame(References.TITLE);
	private static Game game = new Game();
	
	public static GameStates state = GameStates.GAME;
	private Thread game_thread;
	private Renderer gfx;
	
	public SplashScreen splash;
	
	public static Game getInstance(){
		return game;
	}
	
	private void init() {
		ResourceLoader.loadImages();
		splash = new SplashScreen();
		gfx = new Renderer();		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(6,0,40));
		g.fillRect(0, 0, References.WIDTH, References.HEIGHT);
		
		///////////////////////////////////////////////////
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		
		g.dispose();
		bs.show();
		
	}


	/**
	 * 
	 */
	private void tick() {
		
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while (References.isRunning){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if (delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				
			//System.out.println("UDS: " + ticks + ", FPS: " + frames);
										
			ticks=0;
			frames=0;
			}
		}
		
		stop();
	}			

	private synchronized void start(){
		if (References.isRunning)
			return;
		References.isRunning = true;
		game_thread = new Thread(this);
		game_thread.start();
	}
	
	private synchronized void stop(){
		if (!References.isRunning)
			return;
		References.isRunning = false;
		
		try {
			game_thread.join();
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.exit(1);
	}	

	public static void main(String[] args) {
		// Sets the game window size.
		game.setPreferredSize(new Dimension(References.WIDTH, References.HEIGHT));
		game.setMinimumSize(new Dimension(References.WIDTH, References.HEIGHT));
		game.setMaximumSize(new Dimension(References.WIDTH, References.HEIGHT));
		
		// Changes the default mouse cursor.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(References.SPRITES_DIR + "cursor.gif");
		Point hotSpot = new Point(0,0);
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Hand");
		

		//Changes the default java program icon to a custom one.
		Image icon = toolkit.getImage(References.SPRITES_DIR + "icon.png");

		

		frame.add(game);
		frame.setCursor(cursor);
		frame.setIconImage(icon);
		frame.setSize(References.WIDTH, References.HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
				
		game.start();
	}	
}
