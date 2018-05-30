package com.cleitech.jira.logwork

import feign.Param
import feign.QueryMap
import feign.RequestLine

interface SearchIssueClient {
    @RequestLine("GET /rest/api/2/search?jql={jql}")
    fun searchByJQL(@Param("jql") jql:String):SearchIssueResource
}