/*
 * Copyright (C) 2020  Pr. Olivier Gruber
 * Educational software for a basic game development
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: March, 2020
 *      Author: Pr. Olivier Gruber
 */
package info3.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import info3.game.graphics.GameCanvasListener;

public class CanvasListener implements GameCanvasListener {
  Game m_game;
  ArrayList<Integer> pressedKeys;

  CanvasListener(Game game) {
    m_game = game;
    this.pressedKeys = new ArrayList<Integer>();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    System.out.println("Mouse dragged: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    System.out.println("Mouse moved: ("+e.getX()+","+e.getY()+")");
    System.out.println("   modifiers="+e.getModifiersEx());
    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("Key typed: "+e.getKeyChar()+" code="+e.getKeyCode());
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("Key pressed: "+e.getKeyChar()+" code="+e.getKeyCode());
    if (!this.pressedKeys.contains(e.getKeyCode()))
    	this.pressedKeys.add(e.getKeyCode());    Iterator<Integer> itr = this.pressedKeys.iterator();
        while (itr.hasNext()) {
        	this.keyAction(itr.next());
        }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("Key released: "+e.getKeyChar()+" code="+e.getKeyCode());
    if (this.pressedKeys.contains(e.getKeyCode()))
    	this.pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
  }

  @Override
  public void tick(long elapsed) {
    m_game.tick(elapsed);
    Iterator<Integer> itr = this.pressedKeys.iterator();
    while (itr.hasNext()) {
    	this.keyAction(itr.next());
    }
  }

  @Override
  public void paint(Graphics g) {
    m_game.paint(g);
  }

  @Override
  public void windowOpened() {
    m_game.loadMusic();
//    m_game.m_canvas.setTimer(6000);
  }

  @Override
  public void exit() {
  }

//  boolean m_expired;
  @Override
  public void endOfPlay(String name) {
//    if (!m_expired) // only reload if it was a forced reload by timer
      m_game.loadMusic();
//    m_expired = false;
  }

  @Override
  public void expired() { 
    // will force a change of music, after 6s of play
//    System.out.println("Forcing an ealy change of music");
//    m_expired = true;
//    m_game.loadMusic();    
  }
  
  private void keyAction(Integer KeyCode) {
	    switch (KeyCode) {
		case KeyEvent.VK_LEFT:
			this.m_game.m_cowboy.move(0);
			break;
		case KeyEvent.VK_UP:
			this.m_game.m_cowboy.move(1);
			break;
		case KeyEvent.VK_RIGHT:
			this.m_game.m_cowboy.move(2);
			break;
		case KeyEvent.VK_DOWN:
			this.m_game.m_cowboy.move(3);
			break;
		case KeyEvent.VK_Q:
			this.m_game.m_cowboy2.move(0);
			break;
		case KeyEvent.VK_Z:
			this.m_game.m_cowboy2.move(1);
			break;
		case KeyEvent.VK_D:
			this.m_game.m_cowboy2.move(2);
			break;
		case KeyEvent.VK_S:
			this.m_game.m_cowboy2.move(3);
			break;
		default:
			break;
		}
  }

}
