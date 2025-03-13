# Liquibase License Checker

A Liquibase extension that provides a command to check if a Liquibase Pro license is valid.

## Overview

This extension adds a `licenseCheck` command to Liquibase that validates whether the current Pro license is valid. It's designed to be used as a dependency in Liquibase Pro projects to ensure that only valid licenses are used with Pro features.

## Requirements

- Java 8 or higher
- Liquibase Core 4.24.0 or higher

## Installation

To use this extension in your project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.liquibase</groupId>
    <artifactId>liquibase-license-checker</artifactId>
    <version>1.0.0</version>
</dependency>
```

Or download the JAR file and add it to liquibase lib folder. 

## Usage

The extension registers a Liquibase command that can be invoked to check if a Pro license is valid:

```
liquibase licenseCheck
```

If the license is invalid, the command will throw an exception.

### Programmatic Usage

```java
CommandScope commandScope = new CommandScope("licenseCheck");
commandScope.execute();
```

## Development

### Building the Project

```bash
mvn clean install
```

### Running Tests

```bash
mvn test
```

## License

This project is licensed under the Apache License.
