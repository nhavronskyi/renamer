package com.photo_converter.config;

import com.photo_converter.props.PathProps;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
@RequiredArgsConstructor
public class CreatorConfig {
    private final PathProps props;

    @SneakyThrows
    @Bean
    public void packageCreator() {
        Files.createDirectories(Path.of(props.path()));
    }
}
