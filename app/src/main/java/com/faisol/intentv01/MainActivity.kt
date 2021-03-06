package com.faisol.intentv01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialActivity: Button
    private lateinit var btnMoveActivityForResult: Button
    private lateinit var btnExit: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialActivity = findViewById(R.id.btn_dial_number)
        btnDialActivity.setOnClickListener(this)

        btnMoveActivityForResult = findViewById(R.id.btn_move_activity_for_result)
        btnMoveActivityForResult.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_move_activity_for_result)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        ColorReceived()

        btnExit = findViewById(R.id.btn_exit)
        btnExit.setOnClickListener(this)
    }

    private fun ColorReceived() {
        val bundle = intent.extras
        val some = bundle?.getString("Something")
        tvResult.text = some
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.btn_move_activity -> run{
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_with_data -> run{
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "Faisol")
                    bundle.putString("Alamat", "Kediri")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> run{
                    val intent = Intent(this, DialActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_activity_for_result -> run{
                    val intent = Intent(this, MoveActivityForResult::class.java)
                    startActivity(intent)
                }

                R.id.btn_move_activity_for_result -> run{
                    val intent = Intent(this, MoveActivityForResult::class.java)
                    startActivity(intent)
                }
                R.id.btn_exit -> run{
                    finish()
                    closeContextMenu()
                    closeOptionsMenu()
                    System.exit(0)
                }
            }
        }
    }
}