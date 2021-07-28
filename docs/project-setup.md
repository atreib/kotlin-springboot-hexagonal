# 📁 Project initial setup

This project uses Kotlin with Spring Boot. To initiate the project, we're going to use the **spring initializr** ([https://start.spring.io/](https://start.spring.io/)). Access the spring initializr page and select the following settings:

- **Project:** Gradle
- **Language:** Kotlin
- **Springboot:** 2.5.2
- **Packaging:** Jar
- **JAVA:** 16
- **Dependencies:**
    - Spring Boot DevTools
    - Spring Web

After setting the values as above, download the project. Extract the downloaded file inside the directory where you want to store the project. To do this, run: `unzip project.zip`.

### References

[https://spring.io/guides/tutorials/spring-boot-kotlin/](https://spring.io/guides/tutorials/spring-boot-kotlin/)

[https://docs.spring.io/initializr/docs/current/reference/html/#packaging](https://docs.spring.io/initializr/docs/current/reference/html/#packaging)

# 👨🏻‍🏫 Linter setup

As our project's linter tool, we're going to use the `ktlint`.

To set up the ktlint in our project, we only have to add the plugin to the plugins list, inside the build file of the project, `./build.gradle.kts`:

```bash
plugins {
    ...
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}
```

After adding this new plugin and syncing the gradle, we're going to have two new commands:

- `./gradlew ktlintCheck`: Check our code format
- `./gradlew ktlintFormat`: Format our code

### References

[https://ktlint.github.io/](https://ktlint.github.io/)

# ✍🏻 Automated tests setup

Since we created our project with Spring Boot, JUNit is already set up for automated tests in our project.

Besides JUnit 5, we also enable Mockito as our class mock library. To do so, update the `./build.gradle.kts` file:

```
dependencies {
    ...
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core:3.3.3")
}
```

At each test run, JUnit is going to generate a report of our executed tests. This report is store in `./build/reports/tests/test/index.html`.

The test coverage of our code is automatic and can be found inside our project through our IDE, IntelliJ IDEA. To run and see our code coverage, access: `Run -> Run {applicationName} with Coverage`.

- To execute our project tests, run `./gradlew test` or click at the run tests button (represented by a ▶️ icon) in a test class.

### References

[https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)

[https://site.mockito.org/](https://site.mockito.org/)

# 📜 Code documentation setup

For generating our code documentation, we're using the KDoc syntax, the kotlin docstring, with the Dokka library (responsible for generating/exporting the documentation).

To set up Dokka in our project, add to our project build file, `./build.gradle.kts`:

```bash
plugins {
    ...
    id("org.jetbrains.dokka") version "1.5.0"
}
```

- To generate/update our documentation, just run: `./gradlew dokkaHtml`
    - A HTML page with our documentation is going to be generated and stored inside `./build/dokka/html/index.html`.

### References

[https://github.com/Kotlin/dokka](https://github.com/Kotlin/dokka)

[https://kotlinlang.org/docs/kotlin-doc.html#see-identifier](https://kotlinlang.org/docs/kotlin-doc.html#see-identifier)

# 📍 Endpoints documentation setup

For our API endpoints documentation, we're going to use Swagger.

Let's Add `swagger` and `swagger-ui` to our project dependencies, inside the file `./build.gradle.kts`:

```bash
dependencies {
    ...
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
}
```

With the new dependencies and the gradle synced, we're going to create a swagger configuration file (it's a simple Kotlin class), `SwaggerConfig.kt` (in our package root), with the following rules:

```kotlin
package br.com.andretreib.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    open fun api() =
        Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.andretreib.api"))
            .build()
}
```

In this file, we set the Swagger is only going to show the endpoints inside our package `br.com.andretreib.api`.

With this set up correctly done, we only need to use the Swagger rules and annotations tags ([https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)).

### References

[https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

[https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)