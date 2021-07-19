# 🥽 Kotlin + Springboot + Hexagonal Arch 

![docs/diagram/project.png](docs/diagram/project.png)

Atualizado em 16/07/2021. Projeto criado na ferramenta draw.io e disponibilizado em `./docs/diagram/project.drawio`.

# 🔖 Documentações:

- [Configuração de ambiente](docs/environment-setup.md)
- [Configuração inicial do projeto](docs/project-setup.md)
- [Processo de desenvolvimento](docs/development-process.md)

# 👨🏻‍💻 Lista de comandos:

- Ver todas as tarefas: `./gradlew tasks`
- Checar formatação do código: `./gradlew ktlintCheck`
- Formatar o código: `./gradlew ktlintFormat`
- Executar projeto para desenvolvimento: `./gradlew bootRun`
- Executar testes automatizados: `./gradlew test`
- Gerar documentação do código: `./gradlew dokkaHtml`
- Visualizar documentação das rotas (projeto deve estar em execução): Acessar `http://localhost:8080/swagger-ui.html`