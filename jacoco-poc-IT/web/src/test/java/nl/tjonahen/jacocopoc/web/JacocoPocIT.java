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
package nl.tjonahen.jacocopoc.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Assert;
import org.junit.Test;

/**
 * This is the integration test
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class JacocoPocIT {

    @Test
    public void callRestFullService() {
        try {
            final URL url = new URL("http://localhost:8088/web/webresources/generic");
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    Assert.assertEquals("aap:aap+noot:noot", line);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
