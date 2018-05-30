package com.cleitech.jira.logwork

data class WorklogResource(val worklogs:List<Worklog> )
data class Worklog (val author:Author, val started:String, val timeSpentSeconds:Int)

data class Author(val name:String)