package DesignPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private final String directoryName;
    private final List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory " + directoryName + " is present");
        fileSystemList.forEach(FileSystem::ls);
    }
}
