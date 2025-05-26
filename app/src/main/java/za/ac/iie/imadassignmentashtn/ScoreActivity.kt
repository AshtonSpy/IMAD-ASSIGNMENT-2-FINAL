package za.ac.iie.imadassignmentashtn

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val feedback = if (score >= 3) "Great job!" else "Keep practising!"
        scoreTextView.text = "You scored $score/5. $feedback"

        reviewButton.setOnClickListener {

        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
