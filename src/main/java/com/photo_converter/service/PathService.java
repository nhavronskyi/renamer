package com.photo_converter.service;

import java.nio.file.Path;
import java.util.List;

public interface PathService {
    List<Path> getAllFilesPaths(String directoryName);

    List<Path> getAllFilesPaths();

    List<Path> getAllDirectoryPaths();
}
