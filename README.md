# RequestMaker

This API provides a fluent interface to make HTTP requests. The request methods available are:
+ GET
+ POST
+ PUT
+ DELETE
+ PATCH

## Quick use
```
//GET
val requestResponse = RequestMaker().toEndpoint("https://jsonplaceholder.typicode.com/users/1")
                                    .addToHeader("Content-Type", "application/json")
                                    .doGet()
                                    
//POST
val requestResponse = RequestMaker().toEndpoint("http://www.mocky.io/v2/596a5f03110000920701cd92")
                                    .addToHeader("Content-Type", "application/json")
                                    .withObjectRequest("{\"x\":\"Apple\", \"y\":\"Mango\"}")
                                    .doPost()
```

