# The Twitter Tests

This repository contains recruitment challenge for QAA position.

* Implement maximum amount of twitter for a 
[search endpoint](https://developer.twitter.com/en/docs/twitter-api/tweets/search/api-reference/get-tweets-search-all) 
using a boundary values and equivalence partitioning test design techniques
* Tests should be implemented using a real account and using stub
* Frameworks and libraries
  * Java + Gradle + JUnit5 
  * [AsyncHttpClient](https://github.com/AsyncHttpClient/async-http-client) 
  * [AssertJ](https://joel-costigliola.github.io/assertj/index.html)
  * [Selenium Web driver](https://www.selenium.dev/documentation/webdriver/)
  * [Google Guava](https://github.com/google/guava) 
  * [Google Gson or Jackson](https://www.baeldung.com/jackson)
  * [Light bend config](https://github.com/lightbend/config)
  * [Spring boot](https://spring.io/projects/spring-boot)
  * [Mockito](https://site.mockito.org/)
* It is not necessary to use all frameworks, use only those which are required for implementation
* Mark each test or group of twitter with the unique @Tag annotation 
* All twitter should be built to a Jar file and if there is a parameter, in a run command — run all twitter with this key, 
if there is no parameter — run all twitter


## Troubleshooting

The `main` and `test` directories are marked as modules in Intellij IDEA — add the `resolveModulePerSourceSet` option 
to the `.idea/gradle.xml` file:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  ...
  <GradleProjectSettings>
    <option name="resolveModulePerSourceSet" value="false" />
  </GradleProjectSettings>
  ...
</project>
```
