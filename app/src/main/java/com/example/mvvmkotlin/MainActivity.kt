package com.example.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer


import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = Injector.provideCommentViewModelFactory()

        val viewModel = ViewModelProviders.of(this, factory)
            .get(CommentViewModel::class.java)

        viewModel.getComment().observe(this, Observer { comment ->
            val stringBuilder = StringBuilder()
            comment.forEach { comment -> stringBuilder.append("$comment\n\n")}
            textView_comments.text = stringBuilder.toString()
        })

        button_add_comment.setOnClickListener {
            val comment = Comment(editText_comment.text.toString(), editText_author.text.toString())
            viewModel.addComment(comment)
            editText_comment.setText("")
            editText_author.setText("")
        }
    }

}

