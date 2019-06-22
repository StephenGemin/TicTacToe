package com.example.tictactoelocal

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    var availBoxes = mutableListOf<Int>()

    protected fun buClick(view:View){
        val buSelected:Button = view as Button
        var cellID = 0
        when (buSelected.id){
            R.id.bu1 -> cellID=1
            R.id.bu2 -> cellID=2
            R.id.bu3 -> cellID=3
            R.id.bu4 -> cellID=4
            R.id.bu5 -> cellID=5
            R.id.bu6 -> cellID=6
            R.id.bu7 -> cellID=7
            R.id.bu8 -> cellID=8
            R.id.bu9 -> cellID=9
        }

        playGame(cellID, buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1


    fun playGame(cellID:Int, buSelected:Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setTextColor(Color.WHITE)
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
        } else {
            buSelected.text = "O"
            buSelected.setTextColor(Color.WHITE)
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            activePlayer = 1

        }

        buSelected.isEnabled = false
        checkWinner()
        checkDraw()
    }

    fun checkDraw(){
        var counter = 0
        for (cellnum in 1..9){

            if (player1.contains(cellnum) || player2.contains(cellnum )){
//                Toast.makeText(this, "CELLNUM is: " + cellnum + "COUNTER is: " + counter, Toast.LENGTH_SHORT).show()
                counter += 1
            }
                if (counter == 9){
                    Toast.makeText(this, getString(R.string.draw), Toast.LENGTH_LONG).show()
                }
        }
    }

    fun checkWinner(){
        var winner = -1

        // row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        // row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        // row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        // col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        // col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        // col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        // diag2
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        // diag3
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }
            if (winner != -1) {
                if (winner == 1) {
                    Toast.makeText(this, getString(R.string.p1), Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, getString(R.string.p2), Toast.LENGTH_LONG).show()
                }
            }
        }
}
