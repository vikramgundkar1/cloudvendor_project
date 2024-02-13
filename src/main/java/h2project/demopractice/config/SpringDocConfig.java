package h2project.demopractice.config;

import io.swagger.annotations.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info= @Info(description = "Cloudvendor application", title="Cloudvendor Application and Equipment", version = "1.0.0"))
@Configuration
@SecurityScheme(
        name="basicAutth",
        type= SecuritySchemeType.HTTP,
        scheme="basic"

)
public class SpringDocConfig {


    @Bean
    public GroupedOpenApi adminApi() {

        return GroupedOpenApi.builder()
                .group("Product Domain-CloudVendor")
                .pathsToExclude("/")
                .pathsToMatch("/cloudvendor/**")
                .build();


    }
}
