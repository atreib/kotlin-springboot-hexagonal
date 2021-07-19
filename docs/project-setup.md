# 📁 Configuração inicial do projeto

O projeto utiliza Kotlin com Springboot. Para iniciar o projeto, vamos utilizar o **spring initializr** ([https://start.spring.io/](https://start.spring.io/)). Acesse a página do spring initializr e selecione as seguintes configurações:

- **Project:** Gradle
- **Language:** Kotlin
- **Springboot:** 2.5.2
- **Packaging:** Jar
- **JAVA:** 16
- **Dependencies:**
    - Spring Boot DevTools
    - Spring Web

Após configurar conforme indicações acima, faça o download do projeto. Após o download ser concluído, extraia o arquivo do projeto no diretório que você deseja utilizar para o desenvolvimento do projeto. Para isto, acesse o diretório através do terminal e execute: `unzip project.zip`

### Referências

[https://spring.io/guides/tutorials/spring-boot-kotlin/](https://spring.io/guides/tutorials/spring-boot-kotlin/)

[https://docs.spring.io/initializr/docs/current/reference/html/#packaging](https://docs.spring.io/initializr/docs/current/reference/html/#packaging)

# 👨🏻‍🏫 Configuração de linter

Como ferramenta de linter do nosso projeto, utilizaremos o `ktlint`.

Para configurar o ktlint no projeto, temos apenas que adicionar o plugin ao final da lista de plugins no arquivo de build do projeto, `./build.gradle.kts`:

```bash
plugins {
    ...
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}
```

A partir disto, teremos dois novos comandos adicionados ao nosso gradle:

- `./gradlew ktlintCheck`: Verificação da formatação do código
- `./gradlew ktlintFormat`: Formatação automática do código

Lembrando que para verificar todos os comandos disponíveis no nosso projeto, basta rodar `./gradlew tasks`.

### Referências

[https://ktlint.github.io/](https://ktlint.github.io/)

# ✍🏻 Configuração de testes automatizados

Por termos iniciado o nosso projeto com a utilização do springboot, já está configurada a biblioteca JUnit para testes automatizados.

A cada execução dos testes, o JUnit irá disponibilizar um relatório dos testes executados. Este relatório é armazenado em `./build/reports/tests/test/index.html`.

A cobertura de testes do código é automaticamente gerada e pode ser encontrada dentro do projeto através da própria IDE, IntelliJ IDEA. Para executar e visualizar a cobertura de testes, basta executar o comando: `Run -> Run {applicationName} with Coverage`.

- Para executar os testes do projeto, basta rodar: `./gradlew test`.

### Referências

[https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)

# 📜 Configuração de documentação de código

Para geração da documentação do código, utilizamos a sintaxe KDoc, sendo as docstrings do Kotlin, junto à ferramenta Dokka, responsável pela geração da documentação.

Para a configuração da Dokka no projeto, adicione no arquivo `./build.gradle.kts`:

```bash
plugins {
    ...
    id("org.jetbrains.dokka") version "1.5.0"
}
```

- Para gerar/atualizar a documentação, basta executar: `./gradlew dokkaHtml`
    - Uma página HTML com a documentação será gerada e armazenada em `./build/dokka/html/index.html`.

### Referências

[https://github.com/Kotlin/dokka](https://github.com/Kotlin/dokka)

[https://kotlinlang.org/docs/kotlin-doc.html#see-identifier](https://kotlinlang.org/docs/kotlin-doc.html#see-identifier)

# 📍Configuração de documentação de rotas

Para documentação das rotas/endpoints da nossa API, vamos utilizar o Swagger.

Adicionamos o `swagger` e o `swagger-ui` às dependências do projeto, no arquivo `./build.gradle.kts`:

```bash
dependencies {
    ...
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
}
```

Com as novas dependências inseridas e com o *gradle* sincronizado, criamos o arquivo de configuração do swagger (uma classe Kotlin simples), `SwaggerConfig.kt` (na raíz da pasta do nosso package), com a seguinte configuração:

```kotlin
package br.com.andretreib.example

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
            .apis(RequestHandlerSelectors.basePackage("br.com.andretreib.example"))
            .build();
}
```

Na configuração, estabelecemos que o Swagger só irá apresentar os endpoints dentro do package `br.com.andretreib.example`. Com a configuração feita corretamente, basta utilizar as tags de anotação do próprio Swagger ([https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)).

### Referências

[https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
[https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)