package com.photo_converter.config;

import com.photo_converter.service.PhotoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConverterConfig {
    private final PhotoConverter photoConverter;

    @Bean
    public void convert() {
        photoConverter.convert();
    }
}
