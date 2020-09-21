package com.example.mvvmkotlin

import androidx.lifecycle.ViewModel

class CommentViewModel (private val commentRepository: CommentRepository) : ViewModel() {

    fun getComment() = commentRepository.getComment()

    fun addComment(comment: Comment) = commentRepository.addComment(comment)

}