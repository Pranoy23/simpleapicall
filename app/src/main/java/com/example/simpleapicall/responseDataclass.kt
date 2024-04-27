package com.example.simpleapicall

data class responseDataclass(
    val   postLink:String,
    val subreddit:Boolean,
    val title:String,
    val url:String,
    val nsfw:Boolean,
    val spoiler:Boolean,
    val author: String,
    val ups:Int,
    val preview:List<String>
)
