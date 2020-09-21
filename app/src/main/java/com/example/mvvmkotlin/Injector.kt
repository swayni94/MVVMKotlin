package com.example.mvvmkotlin

object Injector {
    fun provideCommentViewModelFactory(): CommentViewModelFactory {
        val commentRepository = CommentRepository.getInstance(FakeDatabase.getInstance().commentDao)
        return CommentViewModelFactory(commentRepository)
    }
}