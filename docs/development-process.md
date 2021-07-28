# ⏹️ Architecture diagram

This project development is being driven by our architecture diagram. This diagram doesn't have any particular pattern, just being used as an easy and fast view of the solution.

So, the architecture must always be updated accordingly to the solution last version.

- The diagram project can be found inside the directory `./docs/diagram/project.png`.
- The tool that is being used is [draw.io](https://app.diagrams.net/).
- Every new version must be available in the .png extension and be saved at `./docs/diagram/project.png`.
  - You can open the .png file as a project inside [draw.io](https://app.diagrams.net/)
  - When saving the project after updating it, choose "File" -> "Export as" -> "PNG" and **check the option "Include a copy of my diagram"**. Then, replace the `./docs/diagram/project.png` file by the exported (and new) one.  

### References

[https://app.diagrams.net/](https://app.diagrams.net/)

# 📜 Code documentation

Beside the documentations of project and environment setup, we also document the code, generated automatically through docstrings (Kdocs pattern with Dokka library). So that it doesn't become a block, another documentations techniques are used (like the architecture diagram).

The best documentation is a clean code, well formatted and easy to read. Anyway, we document the core classes and interfaces of each layer to help to maintain the code.

### References

[https://kotlinlang.org/docs/kotlin-doc.html#see-identifier](https://kotlinlang.org/docs/kotlin-doc.html#see-identifier)

# 📍 Endpoints documentation

Every controller created in the `./presentation/controllers` layer, that has any endpoint, must be documented (description and return) with Swagger, using the library rules and annotations. Also, the `data classes` created to work with the `controller`, stored in `./presentation/projections`, also must be documented (properties and types). The endpoints documented are going to be available through swagger-ui.

To see more about the Swagger rules and annotations, read the documentation of other endpoints from this project or read the Swagger documentation ([https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)).

To access the Swagger UI (the documentation website), just run the project and access `http://localhost:8080/swagger-ui.html`.

### References

[https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)

# ✅ Unit tests

Our project has JUnit 5 and Mockito for automating tests. We don't strictly apply TDD, trying to achieve a 100% coverage, but we try to cover our domain methods and expected exceptions.

To see more about the JUnit tests, read their documentation ([https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)). And, to read more about mocking classes, read the Mockito documentation ([https://site.mockito.org/](https://site.mockito.org/)).

You can check the code coverage through Intellij IDEA, by clicking to run a test class and selecting "Run CLASSNAME with coverage".

### References

[https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)

[https://site.mockito.org/](https://site.mockito.org/)