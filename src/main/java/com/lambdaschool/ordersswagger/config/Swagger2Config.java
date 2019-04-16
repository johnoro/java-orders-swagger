package com.lambdaschool.ordersswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
      .apis(RequestHandlerSelectors.basePackage("com.lambdaschool.ordersswagger"))
      .paths(PathSelectors.regex("/.*"))
      .build().apiInfo(apiEndPointsInfo());
  }

  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder().title("Orders with Swagger")
      .description("Orders Revisited with CRUD")
      .contact(new Contact("John O'Rourke", "https://johnoro.netlify.com/", "officialjohnorourke@gmail.com"))
      .license("MIT")
      .licenseUrl("https://github.com/johnoro/java-orders-swagger/blob/master/LICENSE")
      .version("0.0.1")
      .build();
  }
}
