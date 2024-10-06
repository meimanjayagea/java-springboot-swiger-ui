package co.demo.app;

import org.springframework.boot.SpringApplication;

public class TestAppSwagerUiApplication {

    public static void main(String[] args) {
        SpringApplication.from(AppSwagerUiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
