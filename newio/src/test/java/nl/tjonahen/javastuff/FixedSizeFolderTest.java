/*
 * Copyright (C) 2015 Philippe Tjon - A - Hen, philippe@tjonahen.nl
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
package nl.tjonahen.javastuff;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Philippe Tjon - A - Hen, philippe@tjonahen.nl
 */
public class FixedSizeFolderTest {

    private static final String TEMPFIXEDSIZE = "/tmp/fixedsize";
    private static final String msg = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public FixedSizeFolderTest() {
    }

    @After
    public void cleanup() throws IOException {
        Files.walkFileTree(Paths.get(TEMPFIXEDSIZE), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

        });
    }

    @Before
    public void setup() {
        new java.io.File(TEMPFIXEDSIZE).mkdirs();

    }

    @Test
    public void testConstructor() {
        assertNotNull(new FixedSizeFolder(2, Paths.get(TEMPFIXEDSIZE)));
    }

    @Test
    public void testInit() throws IOException {
        createFiles(3, TEMPFIXEDSIZE);
        FixedSizeFolder ff = new FixedSizeFolder(2, Paths.get(TEMPFIXEDSIZE));
        ff.init();
    }

    private void createFiles(int max, String base) throws IOException {
        for (int i = 0; i < max; i++) {
            Files.write(Paths.get(base + "/duke" + i + ".txt"), msg.getBytes());
        }
    }

    /**
     * Test of add method, of class FixedSizeFolder.
     */
    @Test
    public void testAdd() throws IOException {
        FixedSizeFolder ff = new FixedSizeFolder(2, Paths.get(TEMPFIXEDSIZE));
        ff.init();
        
        // add 3 files, 
        assertTrue(ff.getFolderContent().isEmpty());
        ff.add(Files.write(Paths.get(TEMPFIXEDSIZE + "/duke1.txt"), msg.getBytes()));
        assertEquals(1, ff.getFolderContent().size());
        ff.add(Files.write(Paths.get(TEMPFIXEDSIZE + "/duke2.txt"), msg.getBytes()));
        assertEquals(2, ff.getFolderContent().size());
        ff.add(Files.write(Paths.get(TEMPFIXEDSIZE + "/duke3.txt"), msg.getBytes()));
        assertEquals(2, ff.getFolderContent().size());
        
        // first file (aka oldest) should be removed
        final List<Path> folderContent = ff.getFolderContent();
        assertEquals(TEMPFIXEDSIZE + "/duke2.txt", folderContent.get(0).toString());
        assertEquals(TEMPFIXEDSIZE + "/duke3.txt", folderContent.get(1).toString());
    }

    /**
     * Test of getFolderContent method, of class FixedSizeFolder.
     */
    @Test
    public void testGetFolderContent() throws IOException {
        createFiles(3, TEMPFIXEDSIZE);
        FixedSizeFolder ff = new FixedSizeFolder(2, Paths.get(TEMPFIXEDSIZE));

        assertTrue(ff.getFolderContent().isEmpty());
        ff.init();
        final List<Path> folderContent = ff.getFolderContent();
        assertFalse(folderContent.isEmpty());
        for (Path name : folderContent) {
            BasicFileAttributes attrs = Files.readAttributes(name, BasicFileAttributes.class);
            System.out.println(attrs.creationTime().toString() + " : " + name.toString());
        }

    }
}
