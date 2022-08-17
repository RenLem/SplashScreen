package from.splashscreen

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Explode
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashActivity : AppCompatActivity() {

    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Another way to hide status bar & make full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

/*
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        supportActionBar?.hide()
*/
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_to_splash)
        val dynamcText = findViewById<TextView>(R.id.textView_dynsmic)
        dynamcText.visibility = View.GONE
        Handler().postDelayed({
            dynamcText.startAnimation(animation)
            dynamcText.visibility = View.VISIBLE
        }, 1000)


        // Wait for sometime
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            // Start new activity with transition
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }, 3000)
    }



}