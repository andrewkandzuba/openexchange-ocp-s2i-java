package io.openexchange.openexchange.ocp.s2i.java.rest;

import io.openexchange.openexchange.ocp.s2i.java.model.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetings() {
        HelloWorld response = this.restTemplate
                .getForObject("http://localhost:" + port + "/greetings?name=Andriy", HelloWorld.class);
        assertThat(response.getId()).isGreaterThan(0);
        assertThat(response.getMessage()).contains("Hello Andriy!");
    }
}
