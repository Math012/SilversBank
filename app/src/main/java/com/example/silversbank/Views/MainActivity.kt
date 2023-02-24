package com.example.silversbank.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.database.AppDataBase
import com.example.silversbank.databinding.ActivityMainBinding
import com.example.silversbank.database.models.Login

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao

    //android:inputType="textPassword"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBase = AppDataBase.getDao(this)
        userDao = dataBase.userDao()



        binding.btRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            Thread(Runnable {
                verifyLogin(binding.editLogin.text.toString(),binding.editPassword.text.toString())
            }).start()

        }
    }

    private fun verifyLogin(username:String, password:String) {
        var listUsers = userDao.getLogin()

        if (listUsers.contains(Login(username,password))){
            intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            println("login autenticado")
        }else{
            println("login não autenticado")
        }

    }
}