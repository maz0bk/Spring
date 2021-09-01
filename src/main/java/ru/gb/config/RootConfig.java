package ru.gb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringContextConfiguration.class)
public class RootConfig {
}
