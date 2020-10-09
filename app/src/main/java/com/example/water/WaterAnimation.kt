package com.example.water

import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_water_animation.*


class WaterAnimation : AppCompatActivity() {

    //soundpool for acheiving the gapless audio
    private var soundPool: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_animation)

        // initializing the players
//      val  mediaPlayer = MediaPlayer.create(this, R.raw.watertap)
        soundPool = SoundPool(20, AudioManager.STREAM_MUSIC, 0)
        soundPool!!.load(baseContext, R.raw.watertap, 1)
//        soundPool?.setLoop(1,1)

        //hiding the views accorsing to the requirements
        spray_img.visibility = View.GONE
        stream_img.visibility = View.GONE
        turn_off_img.visibility = View.GONE


        // for playing the sound
        turn_on_img.setOnClickListener {
//            mediaPlayer.start()
//            mediaPlayer.isLooping = true
            soundPool?.play(soundId, 1F, 1F, 0, -1, 1F)
//            soundPool?.setLoop(1,1)
            // hiding the unecessary views
            turn_on_img.visibility = View.GONE
            drop_img.visibility = View.GONE


            // showing the views for pausing the audio
            spray_img.visibility = View.VISIBLE
            stream_img.visibility = View.VISIBLE
            turn_off_img.visibility = View.VISIBLE
        }


        //for pausing the sound
        turn_off_img.setOnClickListener {
//            mediaPlayer.pause()
            soundPool?.autoPause()
            // hiding the unecessary views
            spray_img.visibility = View.GONE
            stream_img.visibility = View.GONE
            turn_off_img.visibility = View.GONE


            // showing the views for resuming the audio
            turn_on_img.visibility = View.VISIBLE
            drop_img.visibility = View.VISIBLE
        }






    }
}