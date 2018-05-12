package com.abuarquemf.requestmaker

import com.google.gson.Gson
import org.junit.Test

class RequestMakerTest {

    val authToken = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjMxMjY1NDEsImlhdCI6MTUyMjI2MjU0MSwidXNlcl9pZCI6NSwicHJvdmlkZXIiOnsiaWQiOjIsImFjdGl2aXRpZXNfaWRzIjpbMSwyLDMsNCw1LDZdfX0.by5nJu3CPo9LBWsIueKL_QXvymUED6nGdw0___MoiiA"

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

    private fun endPointeMake(activityId: Long): String {
        return String.format("http://localhost:8099/activities/$activityId/calendar/price", activityId)
    }

    @Test
    fun shouldNotHaveAccess() {
        val response = RequestMaker().toEndpoint(endPointeMake(5))
                .addToHeader("Content-Type", "application/json")
                .addToHeader("Authorization", authToken)
                .withObjectRequest("{ \"dates\":[\"2018-05-10\", \"2018-05-15\", \"2018-05-13\"] }")
                .doPost()
        println(response)
    }

    data class Ticket(var id: Long = -1,
                      var status: Long = -1,
                      var price: Double = 0.0,
                      var userId: Long = 0,
                      var providerId: Long = 0,
                      var activityState: String = "")

    @Test
    fun shouldGetTicket() {
        val ticketRequest = RequestMaker()
                .toEndpoint("http://localhost:8506/tickets")
                .addToHeader("Content-Type", "application/json")
                .addToHeader("Authorization", authToken)
                .withObjectRequest(Gson().toJson(Ticket(price=505.0)))
                .doPost()
        println(ticketRequest)
    }
}