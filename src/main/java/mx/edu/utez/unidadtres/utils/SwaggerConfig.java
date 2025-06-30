package mx.edu.utez.unidadtres.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI config (){
        return new OpenAPI().info(new Info()
                .title("api rest de almacenes")
                .description("Documentcaicon")
                .version("V1.0"));
    }
}
