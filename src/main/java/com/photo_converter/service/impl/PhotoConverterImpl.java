package com.photo_converter.service.impl;

import com.photo_converter.service.PathService;
import com.photo_converter.service.PhotoConverter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoConverterImpl implements PhotoConverter {
    private final PathService service;

    @SneakyThrows
    @Override
    public void convert() {
        service.getAllDirectoryPaths()
                .forEach(directory -> renamer(getAllHeicPhoto(directory.getFileName().toString())));
    }

    private List<Path> getAllHeicPhoto(String fileName) {
        return service.getAllFilesPaths(fileName)
                .stream()
                .filter(path -> path.getFileName()
                        .toString()
                        .endsWith(".HEIC"))
                .toList();
    }

    @SneakyThrows
    private void renamer(List<Path> paths) {
        for (Path path : paths) {
            Files.move(path, Path.of(path.getParent()
                            .toString())
                    .resolve(String.format("%s.%s", System.currentTimeMillis(), "jpeg")));
        }
    }
}
