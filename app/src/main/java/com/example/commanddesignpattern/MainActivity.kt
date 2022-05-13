package com.example.commanddesignpattern

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.commanddesignpattern.commandPattern.CommandManager
import com.example.commanddesignpattern.commandPattern.WordCommand


class MainActivity : AppCompatActivity() {
    lateinit var wordsList : ListView
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var addToList = findViewById<Button>(R.id.addToList)
         var undo = findViewById<Button>(R.id.undo)
         var redo = findViewById<Button>(R.id.redo)
          wordsList = findViewById(R.id.wordsList)
         var word = findViewById<EditText>(R.id.word)
         var manager = CommandManager()
         appendElements(CommandManager.list)

         addToList.setOnClickListener {
             manager.addWordCommand(WordCommand(word.text.toString() , word))
             appendElements(CommandManager.list)
             word.setText("")
         }

         undo.setOnClickListener {
             manager.undo()
             appendElements(CommandManager.list)
         }

         redo.setOnClickListener {
             manager.redo()
             appendElements(CommandManager.list)
         }


    }


    fun appendElements (objects : ArrayList<WordCommand>){
        var words = ArrayList<String>()
        for ( o in objects){
            if (o.isAct == true) {
                words.add(o.word)
            }
        }
        wordsList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, words)
    }
}