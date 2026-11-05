package com.tca.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Employee REST End-Points",
        version = "1.0.0",
        description = "REST End-Points for Employee CRUD Operations",
        contact = @Contact(
            name = "Employee API Support",
            email = "support@example.com",
            url = "https://example.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    ),
    servers = {
        @Server(
            url = "http://localhost:8082",
            description = "Local Server"
        )
    }
)
public class AppConfig
{
    // No code required
}