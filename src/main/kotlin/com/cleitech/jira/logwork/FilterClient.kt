package com.cleitech.jira.logwork

import feign.Param
import feign.RequestLine


interface FilterClient {
    @RequestLine("GET /rest/api/2/filter/{id} ")
    fun getById(@Param("id") isbn: String): Filter
}