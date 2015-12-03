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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Philippe Tjon - A - Hen, philippe@tjonahen.nl
 */
public class FixedSizeFolder {

    private final FixedSizeArrayList<Path> fixedSizeArrayList;
    private final Path baseFolder;

    /**
     *
     * @param maxFolderSize maximum files in folder
     * @param baseFolder base name of folder containing the files
     */
    public FixedSizeFolder(int maxFolderSize, Path baseFolder) {
        this.fixedSizeArrayList = new FixedSizeArrayList<>(maxFolderSize, new RemoveFile());
        this.baseFolder = baseFolder;
    }

    /**
     * initializes the list of files, including cleanup of the folder
     * @throws IOException -
     */
    public void init() throws IOException {
        final List<Path> fileList = fileList(baseFolder);
        
        Collections.sort(fileList, new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                try {
                    BasicFileAttributes a1 = Files.readAttributes(o1, BasicFileAttributes.class);
                    BasicFileAttributes a2 = Files.readAttributes(o2, BasicFileAttributes.class);
                    
                    return a1.creationTime().compareTo(a2.creationTime());
                } catch (IOException ex) {
                }
                return 0;
            }
        });
        fixedSizeArrayList.addAll(fileList);
    }

    /**
     * Adds new file to the folder
     * @param newFile new file
     */
    public void add(Path newFile) {
        fixedSizeArrayList.add(newFile);
    }
    
    /**
     * get the folder content
     * @return list.
     */
    public List<Path> getFolderContent() {
        return Collections.unmodifiableList(fixedSizeArrayList);
    }
    
    private List<Path> fileList(Path directory) {
        List<Path> files = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                files.add(path);
            }
        } catch (IOException ex) {
        }
        return files;
    }
}
