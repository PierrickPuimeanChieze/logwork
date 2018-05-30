package com.cleitech.jira.logwork

import feign.Param
import feign.RequestLine

interface IssueClient {
    @RequestLine("GET /rest/api/2/issue/{issueId}/worklog")
    fun searchByJQL(@Param("issueId") issueId:String):WorklogResource

}