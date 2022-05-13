package com.example.commanddesignpattern.commandPattern

import android.R
import android.app.Activity
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.commanddesignpattern.MainActivity

class WordCommand : Command{
    lateinit var editText : EditText
    lateinit var word : String
    lateinit var secondWord : String
    var isAct = true
    constructor(  word : String , editText : EditText){
        this.word = word
        this.editText = editText
    }

    override fun undo() {
        isAct = false
        editText!!.setText(word)
    }

    override fun redo() {
        isAct = true
        editText!!.setText("")
        editText!!.setText(secondWord!!)
    }

}