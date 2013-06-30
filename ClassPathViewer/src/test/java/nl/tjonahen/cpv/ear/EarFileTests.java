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
package nl.tjonahen.cpv.ear;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import junit.framework.TestCase;
import nl.tjonahen.cpv.applicationxml.Application;
import nl.tjonahen.cpv.applicationxml.Ejb;
import nl.tjonahen.cpv.applicationxml.Module;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

public class EarFileTests extends TestCase {

    public void testListFiles() {
        EarFile earFile = new EarFile("test/test.ear");
        Iterator<String> it = earFile.getFileNames().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void testGetFile() throws IOException {
        EarFile earFile = new EarFile("test/test.ear");
        earFile.getFile("META-INF/application.xml", new BufferedOutputStream(new ByteArrayOutputStream()));
    }

    public void testGetApplicationXml() throws MarshalException, ValidationException, IOException {
        EarFile earFile = new EarFile("test/test.ear");
        Application app = earFile.getApplicationXml();

        System.out.println("aantal modules :" + app.getModuleCount());
        for (int i = 0; i < app.getModuleCount(); i++) {
            Module module = app.getModule(i);
            Ejb ejbModule = module.getModuleChoice().getEjb();
            if (ejbModule != null) {
                System.out.println("Class-Path van :" + ejbModule.getContent());
                FileOutputStream fos = new FileOutputStream("/tmp/earfile" + i + ".tmp");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                earFile.getFile(ejbModule.getContent(), bos);
                bos.close();
                fos.close();

                JarFile jarFile = new JarFile("/tmp/earfile" + i + ".tmp");
                Manifest manifest = jarFile.getManifest();
                System.out.println(manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH));
            }
            module.getModuleChoice().getWeb();

        }
    }

    public void testGetEjbModules() throws MarshalException, ValidationException, IOException {
        EarFile earFile = new EarFile("test/test.ear");
        List<String> modules = earFile.getEjbModules();
        Iterator<String> it = modules.iterator();
        while (it.hasNext()) {
            JarFile jarFile = earFile.getModule(it.next());
            Manifest manifest = jarFile.getManifest();
            String classPath = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH);
            if (classPath != null) {
                StringTokenizer st = new StringTokenizer(classPath);
                while (st.hasMoreTokens()) {
                    String inJarName = st.nextToken();
                    earFile.getJarFile(inJarName);
                }
            }
        }

    }

    public void testGetWebModules() throws MarshalException, ValidationException, IOException {
        EarFile earFile = new EarFile("test/test.ear");
        List<String> modules = earFile.getWebModules();
        Iterator<String> it = modules.iterator();
        while (it.hasNext()) {
            JarFile jarFile = earFile.getModule(it.next());
            if (jarFile != null) {
                Manifest manifest = jarFile.getManifest();
                String classPath = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH);
                if (classPath != null) {
                    System.out.println(classPath);
                }
            }
        }
    }
}
