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
package nl.tjonahen.cpv;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import nl.tjonahen.cpv.ear.EarFile;
import nl.tjonahen.cpv.ear.ModuleFile;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws ValidationException
     * @throws MarshalException
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: " + Main.class.getName() + " earfile");
            return;
        }
        if (args[0].endsWith(".ear")) {
            printEarClassPath(args);
        } else {
            printJarClassPath(args);
        }

    }

    private static void printJarClassPath(String[] args) {
        try {
            File file = new File(args[0]);

            System.out.println("Inhoud van jarfile: " + file.getName());
            ModuleFile moduleFile = new ModuleFile(true, args[0]);

            printJarClassPath("|---", moduleFile, file.getParent(), new TreeSet<String>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printEarClassPath(String[] args) {
        EarFile earFile = new EarFile(args[0]);

        try {
            System.out.println("Inhoud van earfile: " + args[0]);
            List<String> ejbModules = earFile.getEjbModules();

            Iterator<String> it = ejbModules.iterator();
            while (it.hasNext()) {
                String moduleNaam = it.next();
                printEarModuleClassPath("\t", moduleNaam, earFile);
            }

            List<String> webModules = earFile.getWebModules();

            Iterator<String> itWeb = webModules.iterator();
            while (itWeb.hasNext()) {
                String moduleNaam = itWeb.next();
                printEarModuleClassPath("\t", moduleNaam, earFile);
            }
        } catch (MarshalException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printEarModuleClassPath(String indent, String moduleNaam, EarFile earFile) throws MarshalException, ValidationException, IOException {
        ModuleFile jarFile = earFile.getModule(moduleNaam);
        System.out.println(indent + moduleNaam);
        printJarWarClassPath(indent + "\t", jarFile, earFile, new TreeSet<String>());
    }

    private static void printJarWarClassPath(String indent, ModuleFile jarFile, EarFile earFile, Set<String> filesProcessed) throws IOException {
        if (jarFile == null) {
            return;
        }
        if (filesProcessed.contains(jarFile.getName())) {
            return;
        }
        filesProcessed.add(jarFile.getName());

        Iterator<String> deps = jarFile.getDependencies().iterator();
        while (deps.hasNext()) {
            String inJarName = deps.next();
            System.out.println(indent + "\t" + inJarName);
            ModuleFile jarFile2;
            if (inJarName.startsWith("WEB-INF")) {
                jarFile2 = jarFile.getJarFile(inJarName);
            } else {
                jarFile2 = earFile.getJarFile(inJarName);
            }
            printJarWarClassPath(indent + "\t", jarFile2, earFile, filesProcessed);
        }
    }

    private static void printJarClassPath(String indent, ModuleFile jarFile, String basePathName, Set<String> filesProcessed) throws IOException {
        if (jarFile == null) {
            return;
        }
        if (filesProcessed.contains(jarFile.getName())) {
            return;
        }
        filesProcessed.add(jarFile.getName());

        Iterator<String> deps = jarFile.getDependencies().iterator();
        while (deps.hasNext()) {
            String inJarName = deps.next();
            System.out.println("\t" + indent + inJarName);
            try {
                ModuleFile jarFile2 = new ModuleFile(true, basePathName + File.separator + inJarName);
                printJarClassPath("\t" + indent, jarFile2, basePathName, filesProcessed);
            } catch (IOException ex) {
                continue;
            }
        }
    }
}
