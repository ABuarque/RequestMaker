package com.abuarquemf.requestmaker

import org.junit.Test

class RequestMakerTest {

    @Test
    fun shouldMakeGetRequest() {

        val requestResponse = RequestMaker().toEndpoint("https://jsonplaceholder.typicode.com/users/1")
                                                   .addToHeader("Content-Type", "application/json")
                                                   .doGet()
        println(requestResponse)
    }

    @Test
    fun shouldMakePostRequest() {
        val requestResponse = RequestMaker().toEndpoint("http://www.mocky.io/v2/596a5f03110000920701cd92")
                                                    .addToHeader("Content-Type", "application/json")
                                                    .withObjectRequest("{\"x\":\"Apple\", \"y\":\"Mango\"}")
                                                    .doPost()
        println(requestResponse)
    }

    @Test
    fun shouldNotHaveAccess() {
        val response = RequestMaker().toEndpoint("http://localhost:8099/activities/5/calendar")
                .addToHeader("Content-Type", "application/json")
                .doGet()
        println(response)
    }
}