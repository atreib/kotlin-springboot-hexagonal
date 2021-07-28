# 👨🏻‍💻 Requirements

- Java JDK 16+

# ⚙️ Installing JDK

## 🐧 Linux

1. Install the OpenJDK ([https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot](https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot)).
2. Select the version 16 with HotSpot as our JVM and download it.
3. Move the downloaded `.tar.gz` file to the directory where you want to store the JDK.
    1. We recommend a new folder `java` inside the `/opt` directory, moving the `.tar.gz` file there.
4. Open the directory with the `.tar.gz` file inside the terminal.
5. Extract the `.tar.gz` file for the JDK setup. To do this, run:

    ```bash
    tar xzf OpenJDK16U-jdk_x64_linux_hotspot_16.0.1_9.tar.gz
    ```

6. Now, let's setup our `JAVA_HOME` environment variable with the absolute path to the directory with the downloaded JDK and update the `PATH` environment variable, including `JAVA_HOME`.
    1. Execute `echo $PWD` to view the absolute path to this directory (store that info, we're going to need it in the next step).
    2. Now, we're going to create a new script that is going to run at each user logon (in the OS), updating our environment variable, `PATH`. To do this, run:

        ```bash
        sudo nano /etc/profile.d/jdk_home.sh
        ```

    3. Now, write (in the `jdk_home.sh` file):

        ```bash
        export JAVA_HOME=/opt/java/jdk-16.0.1+9
        export PATH=$JAVA_HOME/bin:$PATH
        ```

       **ATTENTION:** The path `/opt/java/jdk-16.0.1+9` must be the absolute path showed in the step **6.i**.

    4. Save this file by pressing `CTRL` + `X`, typing `Y` and pressing `ENTER`.

7. Logoff and logon in the OS again (or restart your computer).
8. It's all set! To check the operation success, run `java -version`. The showed version must be the same one downloaded in the step **1**.

### References

[https://adoptopenjdk.net/installation.html?variant=openjdk16&jvmVariant=hotspot#x64_linux-jdk](https://adoptopenjdk.net/installation.html?variant=openjdk16&jvmVariant=hotspot#x64_linux-jdk)

[https://keepgrowing.in/java/how-to-permanently-set-java_home-on-ubuntu/](https://keepgrowing.in/java/how-to-permanently-set-java_home-on-ubuntu/)

# 🔨 Recommended tool

## 🐧 Linux: IntelliJ IDEA

Download the last stable version of IntelliJ IDEA Community version ([https://www.jetbrains.com/idea/download/#section=linux](https://www.jetbrains.com/idea/download/#section=linux)) and extrant the downloaded file inside the directory that you want to store the software.

- We recommend you to create a new directory inside `opt`, extracting the IDEA downloaded file inside of it. To do this, open your terminal and run:

```bash
tar xzf ideaIC-2021.1.3.tar.gz
```

To execute the IntelliJ IDEA, open the `bin` folder of the extracted folder and execute `./idea.sh`.

- We recommend you to set up a shortcut in the Linux dock.

### References

[https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)