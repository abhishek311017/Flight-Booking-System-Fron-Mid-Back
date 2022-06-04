package io.project.Apigateway.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("Passenger-Service", "/Passenger-service/v2/api-docs", "2.0"));
		resources.add(swaggerResource("Admin-Service", "/Admin-service/v2/api-docs", "2.0"));
		resources.add(swaggerResource("Search-Service", "/Search-service/v2/api-docs", "2.0"));
		resources.add(swaggerResource("Booking-Service", "/Booking-service/v2/api-docs", "2.0"));
		resources.add(swaggerResource("Fare-Service", "/Fare-service/v2/api-docs", "2.0"));
		resources.add(swaggerResource("Checkin-Service", "/Checkin-service/v2/api-docs", "2.0"));
		
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
