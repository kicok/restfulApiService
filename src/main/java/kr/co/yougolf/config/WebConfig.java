package kr.co.yougolf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {


//		Via EXTENSION(확장자) localhost:8080/person.xml , localhost:8080/person.json
//		configurer.favorParameter(false)
//		.ignoreAcceptHeader(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//		.mediaType("json", MediaType.APPLICATION_JSON)
//		.mediaType("xml", MediaType.APPLICATION_XML);

//		via Query PARAM(파라미터). http://localhost:8080/api/person/v1?mediaType=xml
//		configurer.favorPathExtension(false)
//				.favorParameter(true)
//				.parameterName("mediaType")
//				.ignoreAcceptHeader(true)
//				.useRegisteredExtensionsOnly(false)
//				.defaultContentType(MediaType.APPLICATION_JSON)
//				.mediaType("json", MediaType.APPLICATION_JSON)
//				.mediaType("xml", MediaType.APPLICATION_XML);

		// HEADER (Accept:application/xml) http://localhost:8080/api/person/v1
		configurer.favorPathExtension(false)
				.favorParameter(false)
				.ignoreAcceptHeader(false)
				.useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);

	}
}
       