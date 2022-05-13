package com.example.commanddesignpattern.commandPattern

import android.widget.ListView

interface Command {
    public fun undo ()
    public fun redo ()
}