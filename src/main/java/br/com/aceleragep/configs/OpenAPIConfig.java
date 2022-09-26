package br.com.aceleragep.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springShopOpenApi() {
		OpenAPI openApi = new OpenAPI();

		Info info = new Info();
		info.title("Pedro Balbastro Broso");
		info.version("v0.0.1");
		info.description("<h3>Atividade 03</h3>");
		openApi.info(info);

		openApi.addTagsItem(new Tag().name("Listas").description("Listas da Atividade 03"));
		openApi.addTagsItem(new Tag().name("Itens").description("Itens da Atividade 03"));

		return openApi;
	}

}
