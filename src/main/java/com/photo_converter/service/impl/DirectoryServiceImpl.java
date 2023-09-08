package com.photo_converter.service.impl;

import com.photo_converter.props.PathProps;
import com.photo_converter.service.DirectoryService;
import com.photo_converter.service.PathService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImpl implements DirectoryService {
    private final PathProps pathProps;
    private final PathService pathService;

    @SneakyThrows
    public void renameDirectoryAccordingToPattern() {
        pathService.getAllDirectoryPaths()
                .stream()
                .filter(fileName -> fileName.getFileName()
                        .toString()
                        .matches("\\d+"))
                .forEach(this::renameDirectory);
    }

    @SneakyThrows
    private void renameDirectory(Path dir) {
        var currDate = LocalDate.now();
        var pattern = String.format("%s:%s:%S", dir.getFileName(), currDate.getMonth().getValue(), currDate.getYear());
        Files.move(dir, Path.of(pathProps.path()).resolve(pattern));
    }
}
