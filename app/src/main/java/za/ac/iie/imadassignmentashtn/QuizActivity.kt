package za.ac.iie.imadassignmentashtn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class QuizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var BtnNext: Button

    private val questions = arrayOf(
        "HTML is used to structure web pages",
        "Android apps can only be written in Python",
        "Wi-Fi stands for Wireless Fidelity",
        "RAM is a type of permanent storage",
        "A smartphone is considered a computer"
    )
    private val answers = arrayOf(true, false, true, false, true)

    private var currentQuestionIndex = 0
    private var score = 0
    private var answered = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        BtnNext = findViewById(R.id.BtnNext) //could be broken

        displayQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        BtnNext.setOnClickListener { loadNextQuestion() }
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        feedbackTextView.text = ""
        answered = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (!answered) {
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer) {
                score++
                feedbackTextView.text = "Correct!"
            } else {
                feedbackTextView.text = "Incorrect!"
            }
            answered = true
        }
    }

    private fun loadNextQuestion() {
        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            displayQuestion()
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()
        }
    }
}
