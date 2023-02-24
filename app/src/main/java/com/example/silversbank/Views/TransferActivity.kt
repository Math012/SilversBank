package com.example.silversbank.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.silversbank.R
import com.example.silversbank.database.AppDataBase
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.databinding.ActivityTransferBinding

class TransferActivity : AppCompatActivity() {
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao

    private lateinit var binding: ActivityTransferBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTransferBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dataBase = AppDataBase.getDao(this)
        userDao = dataBase.userDao()

        binding.btTransferValue.setOnClickListener {
            Thread(Runnable {
                var convertValueInt = binding.editValueTransfer.text.toString()
                var convertAccNumberInt = binding.editNumberAccount.text.toString()
                transferValues(convertValueInt.toInt(), convertAccNumberInt.toInt() )
            }).start()
        }
    }

    private fun transferValues(value:Int, accNumber:Int) {
        var listOfAccounts = userDao.getAccNumber()
        if (value == null || accNumber == null){
            println("por favor, preencha todos os dados")
        }else if (listOfAccounts.contains(accNumber)){
            var balanceUser = userDao.getBalance(accNumber)
            balanceUser += value.toDouble()
            userDao.transferValue(balanceUser, accNumber)
            println("transferencia realizada com sucesso")
        }else{
            println("Conta não identificada")
        }






    }
}