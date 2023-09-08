package com.photo_converter.service.impl;

import com.photo_converter.props.PathProps;
import com.photo_converter.service.PathService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PathServiceImpl implements PathService {
    private final PathProps pathProps;

    @Override
    @SneakyThrows
    public List<Path> getAllFilesPaths(String directoryName) {
        List<Path> list = new LinkedList<>();
        try (var stream = Files.newDirectoryStream(Path.of(pathProps.path() + directoryName))) {
            for (Path path : stream) {
                list.add(path);
            }
        }
        return list;
    }

    @Override
    @SneakyThrows
    public List<Path> getAllFilesPaths() {
        return getAllFilesPaths("");
    }

    @Override
    public List<Path> getAllDirectoryPaths() {
        return getAllFilesPaths()
                .stream()
                .filter(path -> !path.getFileName().toString().contains("."))
                .toList();
    }
}
