package com.photo_converter.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dir")
public record PathProps(String path) {
}
