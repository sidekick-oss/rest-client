# rest-client
Simple REST client based on OkHttp HTTP client
# Get a resource
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
