# 👨🏻‍💻 Requisitos

- Java JDK 16+

# ⚙️ Instalando o JDK

## 🐧 Linux

1. Instale o OpenJDK ([https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot](https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot)).
2. Selecione a versão 16 com HotSpot como nosso JVM e faça o download.
3. Mova o arquivo `.tar.gz` baixado para a pasta onde desejas armazenar o JDK
    1. Recomendamos a criação de uma pasta `java` dentro do diretório `/opt` , movendo o arquivo `.tar.gz` para dentro.
4. Abra a pasta com o arquivo `.tar.gz` pelo terminal.
5. Vamos extrair o arquivo `.tar.gz` para configuração deste JDK. Para isto, execute:

    ```bash
    tar xzf OpenJDK16U-jdk_x64_linux_hotspot_16.0.1_9.tar.gz
    ```

6. Agora, vamos configurar a nossa variável de ambiente `JAVA_HOME` com o caminho para a pasta com o nosso novo JDK e atualizar a variável de ambiente `PATH`, incluindo a `JAVA_HOME`.
    1. Execute `echo $PWD` para visualizar o caminho absoluto até a pasta (salve esta informação, vamos usar no próximo passo).
    2. Vamos criar um arquivo de script que será executado a cada login do usuário (no sistema operacional), atualizando a nossa variável de ambiente `PATH`. Para isto, execute:

        ```bash
        sudo nano /etc/profile.d/jdk_home.sh
        ```

    3. Dentro do arquivo, coloque o seguinte conteúdo:

        ```bash
        export JAVA_HOME=/opt/java/jdk-16.0.1+9
        export PATH=$JAVA_HOME/bin:$PATH
        ```

       **ATENÇÃO:** O caminho `/opt/java/jdk-16.0.1+9` é o caminho escolhido conforme recomendação no passo **3.a**. Utilize, aqui, o caminho absoluto executado no passo **6.a**.

    4. Salve o arquivo pressionando `CTRL` + `X`, digitando `Y` e pressionando `ENTER`.

       Dentro do arquivo, coloque o seguinte conteúdo:

7. Faça logoff e login no computador (ou reinicie-o).
8. Pronto! Para verificar o sucesso da operação, execute o comando `java -version`. A versão apresentada deverá ser a mesma que foi baixada no passo **1**.

### Referências

[https://adoptopenjdk.net/installation.html?variant=openjdk16&jvmVariant=hotspot#x64_linux-jdk](https://adoptopenjdk.net/installation.html?variant=openjdk16&jvmVariant=hotspot#x64_linux-jdk)

[https://keepgrowing.in/java/how-to-permanently-set-java_home-on-ubuntu/](https://keepgrowing.in/java/how-to-permanently-set-java_home-on-ubuntu/)

## 💻 Windows

To-do

# 🔨 Ferramenta recomendada

## 🐧 Linux: IntelliJ IDEA

Faça o download da última versão estável do IntelliJ IDEA Community version ([https://www.jetbrains.com/idea/download/#section=linux](https://www.jetbrains.com/idea/download/#section=linux)) e extraia o arquivo baixado no diretório que você deseja manter a instalação armazeada.

- Recomendamos que você crie uma pasta dentro do diretório `opt`, extraindo o IDEA na pasta criada. Para isto, acesse a pasta pelo terminal e execute:

```bash
tar xzf ideaIC-2021.1.3.tar.gz
```

Para executar a IDE, abra a pasta `bin` e execute `./idea.sh` para iniciar a aplicação.

- Recomendamos a configuração de um atalho no dock do Linux, para facilitar o acesso.

### References

[https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)

## 💻 Windows: IntelliJ IDEA

To-do