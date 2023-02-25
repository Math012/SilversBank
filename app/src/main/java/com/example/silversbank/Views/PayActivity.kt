package com.example.silversbank.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.silversbank.database.AppDataBase
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity() {
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao
    private lateinit var binding: ActivityPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataBase = AppDataBase.getDao(this)
        userDao = dataBase.userDao()
        val username = intent.getStringExtra("usernamePay")!!

        binding.btValuePay.setOnClickListener {
            Thread(Runnable {
                var converyValue = binding.editValuePay.text.toString()
                paySystem(username, converyValue.toDouble())
            }).start()
        }


    }

    private fun paySystem(username:String, value: Double) {
        val userON = userDao.getAccountUser(username)
        var total = value - userON.balance
        println(userON.balance)
        println(total)
        if (total <= 0){
            println("Saldo insuficiente")
        }else{
            userDao.transferValue(total,userON.accontNumber)
            println("Pagamento realizado")
        }

    }
}