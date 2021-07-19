# ⏹️ Diagrama de arquitetura

O desenvolvimento do projeto é dirigido pelo diagrama de arquitetura, sendo feita, a partir dele, as implementações da solução. O diagrama não utiliza nenhum padrão obrigatório, sendo apenas uma visualização rápida/fácil da solução de forma macro.

Desta forma, o diagrama de arquitetura deve sempre estar atualizado de acordo com a última versão da solução.

- O projeto do diagrama encontra-se dentro da pasta `./docs/diagram/project.drawio`.
- A ferramenta utilizada é o [draw.io](https://app.diagrams.net/).
- Toda nova versão deve ser disponibilizada no formato .png e salva em `./docs/diagram/project.png`.

### Referências

[https://app.diagrams.net/](https://app.diagrams.net/)

# 📜 Documentação de código

Além das documentações de configuração de ambiente e projeto, também disponibilizamos a documentação do código, gerada de forma automática através de docstrings (KDocs e Dokka). Para não existir um bloqueio no desenvolvimento, outras técnicas de documentação são utilizadas em paralelo (como o diagrama de arquitetura).

A melhor documentação é um código limpo, bem formatado e legível. De qualquer forma, documentamos as interfaces de cada camada da solução utilizando os padrões de KDocs do Kotlin para auxiliar na manutenção do código.

### Referências

[https://kotlinlang.org/docs/kotlin-doc.html#see-identifier](https://kotlinlang.org/docs/kotlin-doc.html#see-identifier)

# 📍 Documentação de rotas

Todo controller criado na camada `./presentation/controllers`, que possua endpoints, deve ser documentado (descrição e retornos) no Swagger, utilizando as anotações da própria biblioteca. Da mesma forma, as `data classes` criadas para atuar com os `controllers`, armazenadas em `./presentation/projections`, também devem ser documentadas (propriedades e tipos). Com a correta documentação, os endpoints são disponibilizados para visualização através do swagger-ui.

Para mais detalhes sobre as anotações do Swagger, veja a documentação de outras endpoints do próprio projeto ou a própria documentação do Swagger ([https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)).

Para visualizar o Swagger UI (a visualização da documentação), basta executar o projeto e acessar `http://localhost:8080/swagger-ui.html`.

### Referências

[https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)