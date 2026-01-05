package pl.tomkan.api25;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Api25ApplicationTests {

	@Test
	void contextLoads() {
	}

}
