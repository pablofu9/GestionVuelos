package com.example.gestionvuelos;

import com.example.gestionvuelos.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SwaggerConfig.class)
public class GestionVuelosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionVuelosApplication.class, args);
    }

}
