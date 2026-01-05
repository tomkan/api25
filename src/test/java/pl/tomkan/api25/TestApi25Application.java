package pl.tomkan.api25;

import org.springframework.boot.SpringApplication;

public class TestApi25Application {

	public static void main(String[] args) {
		SpringApplication.from(Api25Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
