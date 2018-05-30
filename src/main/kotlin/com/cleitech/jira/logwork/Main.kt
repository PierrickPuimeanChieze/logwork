package com.cleitech.jira.logwork

import feign.slf4j.Slf4jLogger
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.Feign
import feign.Logger
import feign.okhttp.OkHttpClient


fun main(args: Array<String>) {
    val filterClient = Feign.builder()
            .client(OkHttpClient())
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .logger(Slf4jLogger(FilterClient::class.java))
            .logLevel(Logger.Level.FULL)
            .target(FilterClient::class.java, "https://jira.atlassian.com")

    val searchIssueClient = Feign.builder()
            .client(OkHttpClient())
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .logger(Slf4jLogger(SearchIssueClient::class.java))
            .logLevel(Logger.Level.FULL)
            .target(SearchIssueClient::class.java, "https://jira.atlassian.com")

    val issueClient = Feign.builder()
            .client(OkHttpClient())
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .logger(Slf4jLogger(IssueClient::class.java))
            .logLevel(Logger.Level.FULL)
            .target(IssueClient::class.java, "https://jira.atlassian.com")

    var filter = filterClient.getById("12844")
    print (filter.jql)
    var searchByJQL = searchIssueClient.searchByJQL(filter.jql)

    for (issue in searchByJQL.issues) {

    }
}


//https://jira.atlassian.com/rest/api/2/filter/12844