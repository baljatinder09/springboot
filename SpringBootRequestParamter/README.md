# Spring boot Request Param example
There are 2 ways we can pass the value from URL to REST Controller. 
  - >@PathVariable
 -  >@RequestParam
```shell
@GetMapping("/{message}")
@PathVariable(name="message", required=false)
 ```
> URL -> http://localhost:9001/message 
> In above URL the message is consider as path variable. attribute Required means it is not mandatory to provide the PathVariable same for RequestParam

```shell
@GetMapping
@RequestParam(name="message" required=true/false defaultValue="default message")
 ```
 > URL -> http://localhost:9001?message=helloSpringboot 
> In above URL the message is consider as param variable. In above syntax defaultValue is considers as default value when we are not giving any value/param in URL

## Requirements
For building and running the application you need.

 - Spring boot version 2.2.2
 - Java 8
 - Apache Maven 3.3.9
 - Eclipse Id

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the  `main`  method in the  `com.singh.SpringBootParamterRequestApplication`  class from your IDE. We have created a simple spring boot project to call the REST service and get simple message on UI screen.

Alternatively you can use the  [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)  like so:
```shell
mvn spring-boot:run
```
# Used the below URL to access Chrome/EDGE/IE Browser

```shell
URL : http://localhost:9001/requestParameter/My%20Java%20Tutorial
URL : http://localhost:9001/requestParameter?message=My%20Java%20Tutorial 
```
[@PathVariable](http://localhost:9001/requestParameter/My%20Java%20Tutorial)
[@RequestParam](http://localhost:9001/requestParameter?message=My%20Java%20Tutorial)

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/springboot/helloSpringboot/blob/master/LICENSE) file.
