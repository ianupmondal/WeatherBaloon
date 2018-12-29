package org.anup.weatherBaloon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"org.anup.weatherBaloon"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class WeatherBaloonApp {

	public static void main(String[] args) {
		SpringApplication.run(WeatherBaloonApp.class, args);

	}
}
