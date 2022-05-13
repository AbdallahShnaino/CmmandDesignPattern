package com.example.commanddesignpattern.commandPattern

class CommandManager {
    companion object{
        var list : ArrayList<WordCommand> = ArrayList<WordCommand>()
        var index = 0

    }
    public fun addWordCommand ( w : WordCommand) {
        list.add(w)
        index++
    }

    public fun undo () {
        if ( index > 0){
            index--
            var obj = list.get(index)
            obj.undo()
        }
    }
    public fun redo () {
        if(index < list.size){
            var obj = list.get(index)
            if ( index == list.size-1){
                obj.secondWord = ""
            }else{
                obj.secondWord = list.get(index+1).word
            }
            obj.redo()
            index++
        }
    }

}