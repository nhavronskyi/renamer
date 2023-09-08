package com.photo_converter;

import com.photo_converter.props.PathProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PathProps.class)
public class PhotoConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoConverterApplication.class, args);
    }

}
