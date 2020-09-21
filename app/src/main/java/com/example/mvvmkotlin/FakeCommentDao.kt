package com.example.mvvmkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCommentDao {

    private val commentList = mutableListOf<Comment>()
    private val comments = MutableLiveData<List<Comment>>()

    init {
        comments.value = commentList
    }

    fun addComment(comment: Comment) {
        commentList.add(comment)
        comments.value = commentList
    }

    fun getComments() = comments as LiveData<List<Comment>>
}