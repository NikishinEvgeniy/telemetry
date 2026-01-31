package ru.ylab.example.telemetry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("[Смок] Тестирование поднятия приложения")
class SmokeTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("Контекст поднят успешно")
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

}