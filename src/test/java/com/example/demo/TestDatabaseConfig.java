package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Testcontainers configuration for integration tests.
 *
 * <p>The {@link PostgreSQLContainer} is declared as a Spring {@link Bean @Bean} with
 * {@link ServiceConnection @ServiceConnection}. This is the recommended approach since
 * Spring Boot 3.1 because Spring manages the container lifecycle — starting it before
 * dependent beans and stopping it after them — which prevents connection errors during
 * shutdown. {@code @ServiceConnection} auto-configures the datasource from the running
 * container, so no {@code application.yml} or manual property wiring is needed in tests.
 *
 * <p>Test classes use this configuration via {@code @Import(TestDatabaseConfig.class)}.
 * Multiple test classes sharing the same {@code @Import} will reuse a single Spring
 * application context (and therefore a single container), making the test suite faster.
 *
 * <h3>Evolution of Testcontainers support in Spring Boot</h3>
 * <ul>
 *   <li><b>Before Spring Boot 3.1</b> — the only options were the Testcontainers JDBC URL
 *       ({@code jdbc:tc:postgresql:...}) or {@code @DynamicPropertySource} with the
 *       {@code @Testcontainers} JUnit extension. Both required manual property wiring and
 *       gave no lifecycle guarantees between containers and Spring beans.</li>
 *   <li><b>Spring Boot 3.1 (May 2023)</b> — introduced {@code @ServiceConnection} for
 *       automatic connection configuration, {@code @TestConfiguration} with container
 *       {@code @Bean} methods for proper lifecycle management, and
 *       {@code @ImportTestcontainers} for sharing container definitions across tests.</li>
 *   <li><b>Spring Boot 3.1+</b> — the {@code @Bean} approach is recommended over the
 *       JUnit {@code @Container} field approach because Spring controls startup and
 *       shutdown ordering. The JUnit approach may shut down the container before Spring
 *       destroys beans that still hold database connections.</li>
 * </ul>
 */
@TestConfiguration(proxyBeanMethods = false)
class TestDatabaseConfig {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgres() {
        return new PostgreSQLContainer<>("postgres:18");
    }
}
