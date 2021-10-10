package com.example.studydiary.Model

import javax.security.auth.Subject

data class Diary(
    val Title : String,
    val subject: Subject,
    val method : String,
    val content : String
)
