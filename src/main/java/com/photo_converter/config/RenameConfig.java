package com.photo_converter.config;

import com.photo_converter.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RenameConfig {
    private final DirectoryService service;

    @Bean
    public void renameFiles() {
        service.renameDirectoryAccordingToPattern();
    }
}
