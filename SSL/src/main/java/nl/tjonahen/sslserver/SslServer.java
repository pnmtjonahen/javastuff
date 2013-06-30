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
package nl.tjonahen.sslserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Security;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import com.sun.net.ssl.internal.ssl.Provider;

public class SslServer {

    private static int sslPort = 1443;

    static {
        Security.addProvider(new Provider());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(sslPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        sslServerSocket.setNeedClientAuth(true);
        boolean stop = false;
        while (!stop) {
            try {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                String test;

                while ((test = bufferedReader.readLine()) != null) {
                    System.out.println(test);
                    if (".".equals(test)) {
                        stop = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
