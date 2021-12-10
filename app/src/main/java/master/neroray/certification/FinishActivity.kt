package master.neroray.certification

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val restartButton:Button=findViewById(R.id.buttonRestart)
        val extendedFab:Button=findViewById(R.id.extended_fab)
        restartButton.setOnClickListener{
            val mainActivityIntent=Intent(this,MainActivity::class.java)

            startActivity(mainActivityIntent)
        }
        extendedFab.setOnClickListener {
            val link:Uri = Uri.parse("https://play.google.com/store")
            val openBrowserIntent=Intent(Intent.ACTION_VIEW,link)
            val chooser=Intent.createChooser(openBrowserIntent,"Browser")
            startActivity(chooser)
        }
    }
}