package cl.naitsirc.sysinus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Systema Ingreso Usuarios API", version = "1.0", description = "API to work with Users"))
public class SysinusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysinusApplication.class, args);
	}

}
