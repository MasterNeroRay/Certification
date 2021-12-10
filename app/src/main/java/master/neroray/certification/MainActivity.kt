package master.neroray.certification

import android.content.Intent
import android.os.Bundle
//import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var questionNo = 0
var questions = listOf("What are the two official languages for Android development? \n\n A) Kotlin and Java \n\n B) Java and Python \n\n C) Kotlin and Python",
    "How do you define a function in Kotlin? \n\n A) void \n\n B) fun \n\n C) function",
    "What is a variable used for? \n\n A) To contain data \n\n B) To insert a random value \n\n C) Don't know",
    "What does SDK stand for in Android SDK? \n\n A) Software Development Kit \n\n B) Software Development Kotlin \n\n C) Something Don't Know")
var rightAnswers = listOf(1, 2, 1, 1)
const val QUESTION_KEY:String="Question"

class MainActivity : AppCompatActivity() {

    lateinit var textView2:TextView

    fun showToast(answer: Int) {
        if (answer==rightAnswers.get(questionNo)) {
            Toast.makeText(applicationContext, getString(R.string.amazing), Toast.LENGTH_SHORT).show()
            updateQuestion()
        } else Toast.makeText(applicationContext,getString(R.string.badluck),Toast.LENGTH_SHORT).show()
    }
    fun updateQuestion() {
        questionNo++
        //textView2.setText(questions.get(questionNo))
        if (questionNo > questions.size-1) {
            val finishActivityIntent:Intent=Intent(this,FinishActivity::class.java)
            questionNo=0
            startActivity(finishActivityIntent)
        }
        else textView2.text = questions.get(questionNo)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1:Button = findViewById(R.id.button1)
        val button2:Button = findViewById(R.id.button2)
        val button3:Button = findViewById(R.id.button3)
        textView2 = findViewById(R.id.textView2)
        if (savedInstanceState!=null)
            textView2.text = savedInstanceState.getString(QUESTION_KEY)
        button1.setOnClickListener {
            showToast(1)
            //Toast.makeText(applicationContext, getString(R.string.amazing), Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            showToast(2)
        }

        button3.setOnClickListener {
            showToast(3)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(QUESTION_KEY,textView2.text.toString())
    }



}
