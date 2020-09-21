package com.example.mvvmkotlin

class FakeDatabase {

    var commentDao = FakeCommentDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}