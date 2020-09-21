package com.example.mvvmkotlin

class CommentRepository private constructor(private val commentDao: FakeCommentDao) {

    fun addComment(comment: Comment) {
        commentDao.addComment(comment)
    }

    fun getComment() = commentDao.getComments()

    companion object {
        @Volatile private var instance: CommentRepository? = null

        fun getInstance(commentDao: FakeCommentDao) =
            instance ?: synchronized(this) {
                instance ?: CommentRepository(commentDao).also { instance = it }
            }
    }
}