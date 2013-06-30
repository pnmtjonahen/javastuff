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
package nl.tjonahen.sslclient;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.security.Security;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import com.sun.net.ssl.internal.ssl.Provider;

public class SslClient {

    private static String serverNaam = "localhost";
    private static int sslPort = 1443;

    static {
        Security.addProvider(new Provider());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            SSLSocket sslSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(serverNaam, sslPort);
            System.out.println("SSL connection met " + serverNaam + ":" + sslPort);
            OutputStreamWriter osw = new OutputStreamWriter(sslSocket.getOutputStream());
            osw.write("hallo daar\n");
            osw.write(".\n");
            osw.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
