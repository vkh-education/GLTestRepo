# Welcome to GL Test exercise repo

**For set up environment do the following steps:**
- Install java JDK 11 in your system and configurate global JAVA_HOME variable, on Mac execute command in terminal
```
brew cask install java
```
- Install Maven 3 in your system and configurate global MAVEN_HOME variable, on Mac:
```
brew install maven
```
- Download project to your machine

## For running TESTS do the following: 
- Open terminal, navigate to project's directory, execute command 
```
mvn clean install test -DapiKey={$valid_api_key} 
```

