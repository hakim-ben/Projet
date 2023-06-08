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
	int m_x = 10, m_y = 10;
	int m_width;
	int m_height;
	int v_y;
	boolean jump_up;
	boolean jump_down;
//	boolean jump_up_right;
//	boolean jump_down_right;
//	boolean jump_up_left;
//	boolean jump_down_left;
	int jump_mode;
	int nb_frame;
	int cpt_frame;
	int t;
	double f = 9.81;

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
//      m_imageIndex =  (m_images.length/4)*3 + ((m_imageIndex + 1) % (m_images.length/4));
//    }
//    m_moveElapsed += elapsed;
//    if (m_moveElapsed>24 & m_width!=0) {
//      m_moveElapsed=0;
//      m_x = (m_x +2)%m_width;
//    }
		m_moveElapsed += elapsed + elapsed;
		if (cpt_frame > nb_frame) {
			if (jump_down) {
				jump_down = false;
			}
			if (jump_up) {
				jump_up = false;
				jump_down();
			}
		}
		if (m_moveElapsed > 50 && jump_up) {
			m_y -= 1 * v_y;
			if(jump_mode == 1) {
				m_x += 5;
			}
			if (jump_mode == 2) {
				m_x -= 5;
			}
			m_moveElapsed = 0;
			v_y -= 1;
			cpt_frame += 1;
		}
		if (m_moveElapsed > 50 && jump_down) {
			if(jump_mode == 1) {
				m_x += 5;
			}
			if (jump_mode == 2) {
				m_x -= 5;
			}
			m_moveElapsed = 0;
			m_y += 1 * v_y;
			v_y += 1;
			cpt_frame += 1;
		}
		
	}

	public void paint(Graphics g, int width, int height) {
		m_width = width;
		m_height = height;
		BufferedImage img = m_images[m_imageIndex];
		int scale = 2;
		g.drawImage(img, m_x, m_y, scale * img.getWidth(), scale * img.getHeight(), null);
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

	public void jump_up(int m) {
//		if (m == 0) {
//			jump_up = true;			
//		}
//		else if (m == 1) {
//			jump_up_right = true;
//		}
//		else {
//			jump_up_left = true;
//		}
		jump_up = true;	
		jump_mode = m;
		v_y = 11;
		nb_frame = 10;
		cpt_frame = 0;
//	  int v = 1;
//	  for (int i = 0; i<4; i++) {
//		  m_y += 10*v;
//		  v += -2;
//	  }
	}

	public void jump_down() {
//		if (m == 0) {
//			jump_down = false;			
//		}
//		else if (m == 1) {
//			jump_down_right = false;
//		}
//		else {
//			jump_down_left = false;
//		}
		jump_down = true;	
		v_y = 1;
		nb_frame = 10;
		cpt_frame = 0;
//	  int v = 1;
//	  for (int i = 0; i<4; i++) {
//		  m_y += 10*v;
//		  v += -2;
//	  }
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
