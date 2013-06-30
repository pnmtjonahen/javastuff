/*
 * Copyright (C) 2013 Philippe Tjon-A-Hen philippe@tjonahen.nl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test security manager.
 * 
 *  Run this with:
 *  java -Djava.security.manager=nl.tjonahen.securitymanager.SecurityManager nl.tjonahen.DummyApplication
 *
 */
public class DummyApplication implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new DummyApplication());
		th1.start();

	}

	public void run() {
		File file;
		try {
			file = File.createTempFile("aaa","aaa");
		} catch (IOException e) {
			Logger.getLogger(DummyApplication.class.getName()).log(Level.SEVERE, "Error create temp.", e);
			return;
		}

		file.deleteOnExit();
		
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile(), true);
		} catch (IOException e) {
			Logger.getLogger(DummyApplication.class.getName()).log(Level.SEVERE, "Error create writer.", e);
			return;
		}
		try {
			for (int i = 0; i < 10; i++) {
				fw.write("123456789012345678901234567890123456789012345678901234567890");
			}
			fw.flush();
		} catch (IOException e) {
			Logger.getLogger(DummyApplication.class.getName()).log(Level.SEVERE, "Error testing.", e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				Logger.getLogger(DummyApplication.class.getName()).log(Level.SEVERE, "Error closing file.", e);
			}
		}
	}
}
