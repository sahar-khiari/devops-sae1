package tn.esprit.tp_foyer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TP Foyer API")
                        .version("1.0.0")
                        .description("""
                    <h3>Documentation for the TP Foyer REST API</h3>
                    <p>This API manages entities like Université, Foyer, Bloc, Chambre, and Étudiant.</p>
                    <ul>
                        <li><a href="http://localhost:8088/tpfoyer/swagger-ui/index.html" target="_blank">
                            Swagger UI
                        </a></li>
                        <li><a href="http://localhost:8088/tpfoyer/v3/api-docs" target="_blank">
                            Raw OpenAPI JSON
                        </a></li>
                        <li><a href="https://springdoc.org/" target="_blank">
                            springdoc-openapi Documentation
                        </a></li>
                    </ul>
                    """)
                        .contact(new Contact()
                                .name("TP Foyer Dev Team")
                                .email("support@tpfoyer.tn")
                                .url("https://www.esprit.tn"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }

    @Bean
    public GroupedOpenApi chambreApi() {
        return GroupedOpenApi.builder()
                .group("Chambre Management")
                .pathsToMatch("/chambre/**")
                .build();
    }


    @Bean
    public GroupedOpenApi blocApi() {
        return GroupedOpenApi.builder()
                .group("Bloc Management")
                .pathsToMatch("/bloc/**")
                .build();
    }

    @Bean
    public GroupedOpenApi reservationApi() {
        return GroupedOpenApi.builder()
                .group("Reservation Management")
                .pathsToMatch("/reservation/**")
                .build();
    }

    @Bean
    public GroupedOpenApi foyerApi() {
        return GroupedOpenApi.builder()
                .group("Foyer Management")
                .pathsToMatch("/foyer/**")
                .build();
    }

    @Bean
    public GroupedOpenApi etudiantApi() {
        return GroupedOpenApi.builder()
                .group("Etudiant Management")
                .pathsToMatch("/etudiant/**")
                .build();
    }

    @Bean
    public GroupedOpenApi universiteApi() {
        return GroupedOpenApi.builder()
                .group("Universite Management")
                .pathsToMatch("/universites/**") // make sure your controller uses /universite not /universites
                .build();
    }

}
