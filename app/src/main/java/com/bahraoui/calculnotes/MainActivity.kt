package com.bahraoui.calculnotes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val calculerBTN = findViewById<Button>(R.id.calculerBTN)
        val moyenne = findViewById<TextView>(R.id.moyenne)

        calculerBTN.setOnClickListener {
            val noteMath = findViewById<EditText>(R.id.noteMath).text.toString()
            val noteSI = findViewById<EditText>(R.id.noteSI).text.toString()
            val notePH = findViewById<EditText>(R.id.notePH).text.toString()
            val noteFR = findViewById<EditText>(R.id.noteFR).text.toString()


                val noteMathDouble = noteMath.toDouble()
                val noteSIDouble = noteSI.toDouble()
                val notePHDouble = notePH.toDouble()
                val noteFRDouble = noteFR.toDouble()

                val moy = (noteMathDouble + noteSIDouble + notePHDouble + noteFRDouble) / 4

                val mention = if (moy in 0.0..10.0) {
                    "Échec"
                } else if (moy in 10.0..12.0) {
                    "Assez-bien"
                } else if (moy in 12.0..14.0) {
                    "Bien"
                } else if (moy in 14.0..16.0) {
                    "Très bien"
                } else if (moy in 16.0..20.0) {
                    "Excellent"
                } else {
                    Toast.makeText(this, "S'il vous plaît entrer une note valide!", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                moyenne.text = "Votre moyenne est: $moy\nVotre mention: $mention"


        }
    }

}