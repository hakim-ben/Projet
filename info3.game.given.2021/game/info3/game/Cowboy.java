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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A simple class that holds the images of a sprite for an animated cowbow.
 *
 */
public class Cowboy {
  BufferedImage[] m_images;
  int m_imageIndex;
  long m_imageElapsed;
  long m_moveElapsed;
  int m_x=200, m_y=100;
  int m_width;
  int m_height;
  int v_y;
	boolean jump_up;
	boolean jump_down;
	int nb_frame = 10;
	int cpt_frame;
	int t;
	double f = 9.81;
	boolean right;
	boolean left;
	

  
  Cowboy() throws IOException {
    m_images = loadSprite("resources/winchester-4x6.png", 4, 6);
  }
  
  /*
   * Simple animation here, the cowbow 
   */
  public void tick(long elapsed) {
//    m_imageElapsed += elapsed;
//    if (m_imageElapsed > 200) {
//      m_imageElapsed = 0;
//      m_imageIndex = (m_imageIndex + 1) % m_images.length;
//    }
	  m_moveElapsed += 2*elapsed;
//    if (m_moveElapsed>24 & m_width!=0) {
//      m_moveElapsed=0;
//      m_x = (m_x +2)%m_width;
//    }
	  
//	  up = true;
//	  if (up && m_moveElapsed>10) {
//		  m_moveElapsed = 0;
//		  m_y = m_y - 10;
//		  up = false;
//		  down = true;
//	  }
//	  if (down && m_moveElapsed>10) {
//		  m_moveElapsed = 0;
//		  m_y = m_y + 10;
//		  down = false;
//	  }
//	  
//		if (cpt_frame > nb_frame) {
//			if (jump_down) {
//				jump_down = false;
//			}
//			if (jump_up) {
//				jump_up = false;
//				jump_down_vertical();
//			}
//		}
//		if (m_moveElapsed > 50 && jump_up) {
//			m_moveElapsed = 0;
//			m_y -= 1 * v_y;
//			
//			//m_x += 5;
//			v_y -= 1;
//			cpt_frame += 1;
//		}
//		if (m_moveElapsed > 50 && jump_down) {
//			m_moveElapsed = 0;
//			m_y += 1 * v_y;
//			//m_x += 5;
//			v_y += 1;
//			cpt_frame += 1;
//		}
	  
	  int x = 0;
	  if (right) {
		  x = 5;
	  }
	  else if (left){
		  x = -5;
	  }
	  jump(m_moveElapsed, x);

	  
  }
  
  
  public void jump(long time, int x) {
	  if (cpt_frame > nb_frame) {
			if (jump_down) {
				jump_down = false;
			}
			if (jump_up) {
				jump_up = false;
				jump_down_vertical();
			}
		}
		if (m_moveElapsed > 50 && jump_up) {
			m_moveElapsed = 0;
			m_y -= 1 * v_y;
			
			m_x += x;
			v_y -= 1;
			cpt_frame += 1;
		}
		if (m_moveElapsed > 50 && jump_down) {
			m_moveElapsed = 0;
			m_y += 1 * v_y;
			m_x += x;
			v_y += 1;
			cpt_frame += 1;
		}
  }
  
  public void up(long time){
	  for (int i = 0; i < 30 && time > 200; i++) {
		  m_y = (m_y - 1);
	  }
  }
  
  public void down(long time){
	  for (int i = 0; i < 30 && time > 200; i++) {
		  m_y = (m_y + 1);
	  }
  }
  
  public void right() {
	  m_x = (m_x + 10)%m_width;
  }
  
  public void left() {
	  m_x = (m_x - 10)%m_width;
  }
  
  public void move_right() {
		m_x = (m_x + 10) % m_width;
		m_imageIndex = 20;
	}

	public void move_left() {
		m_x = (m_x - 10 + m_width) % m_width;
		m_imageIndex = 8;
	}

	public void move_up() {
		m_y = (m_y - 10 + m_height) % m_height;
		m_imageIndex = 14;
	}

	public void move_down() {
		m_y = (m_y + 10) % m_height;
		m_imageIndex = 2;
	}

	private void set_booleans(char c) {
		left = false;
		right = false;
		switch (c) {
		case 'r':
			right = true;
			break;
		case 'l':
			left = true;
			break;
		default:
			break;
		}
	}
	public void jump_up_vertical(char c) {
		set_booleans(c);
		jump_up = true;
		v_y = 11;
		cpt_frame = 0;
//	  int v = 1;
//	  for (int i = 0; i<4; i++) {
//		  m_y += 10*v;
//		  v += -2;
//	  }
	}

	public void jump_down_vertical() {
		jump_down = true;
		v_y = 1;
		cpt_frame = 0;
//	  int v = 1;
//	  for (int i = 0; i<4; i++) {
//		  m_y += 10*v;
//		  v += -2;
//	  }
	}
  
  public void paint(Graphics g, int width, int height) {
    m_width = width;
    m_height = height;
    BufferedImage img = m_images[m_imageIndex];
    int scale = 2;
    g.drawImage(img, m_x, m_y, scale * img.getWidth(), scale * img.getHeight(), null);
  }

  
  public static BufferedImage[] loadSprite(String filename, int nrows, int ncols) throws IOException {
    File imageFile = new File(filename);
    if (imageFile.exists()) {
      BufferedImage image = ImageIO.read(imageFile);
      int width = image.getWidth(null) / ncols;
      int height = image.getHeight(null) / nrows;

      BufferedImage[] images = new BufferedImage[nrows * ncols];
      for (int i = 0; i < nrows; i++) {
        for (int j = 0; j < ncols; j++) {
          int x = j * width;
          int y = i * height;
          images[(i * ncols) + j] = image.getSubimage(x, y, width, height);
        }
      }
      return images;
    }
    return null;
  }

}
