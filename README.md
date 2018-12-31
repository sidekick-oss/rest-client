# rest-client
Simple REST client based on OkHttp HTTP client with Java, Groovy and Kotlin interoperability in mind.
# Get a resource
## Java
```java
// Set configuration
HttpConfig config = new HttpConfig()
    .withConnectTimeout(10)
    .withReadTimeout(10)
    .withWriteTimeout(10);
// Create a new client and set the base URL
HttpClient client = new HttpClient(config);
client.setBaseUrl("https://jsonplaceholder.typicode.com");
// Get a resource
HttpResponse response = client.get(new HttpArgs().withUrl("posts/1"));
Map post = (Map) response.getJson();
```
## Groovy
```groovy
// Set configuration
def config = [
    connectTimeout: 2,
    readTimeout   : 2,
    writeTimeout  : 2
]
// Create a new client and set the base URL
client = HttpClient(config)
client.baseUrl = 'https://jsonplaceholder.typicode.com'
// Get a resource
def response = client.get(url: 'posts/1')
def post = response.json
```
## Kotlin
```kotlin
val config = HttpConfig()
    .withConnectTimeout(2)
    .withReadTimeout(2)
    .withWriteTimeout(2)
client = HttpClient(config)
client.setBaseUrl("https://jsonplaceholder.typicode.com")
val response = client.get(HttpArgs().withUrl("posts").withQuery(query))
val post = response.json
```
