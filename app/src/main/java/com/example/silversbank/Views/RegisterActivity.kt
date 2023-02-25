package com.example.silversbank.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.database.AppDataBase
import com.example.silversbank.database.models.User
import com.example.silversbank.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBase = AppDataBase.getDao(this)
        userDao = dataBase.userDao()


        binding.btRegister.setOnClickListener {
            var accNumberValue:Int = 0
            var balanceValue:Double = 0.0
            Thread(Runnable {
                verifyRegister(
                    binding.editLoginRegister.text.toString(),binding.editPasswordRegister.text.toString(),
                    balanceValue, accNumberValue, binding.editPasswordRegisterVerify.text.toString()
                )
            }).start()
        }
    }

    private fun verifyRegister(username: String, password:String, balance:Double, accNumber:Int, passwordVerify: String){
        //Acessando todos os usuarios que o banco tem para evitar duplicidade no registro
        var listOfUsers = userDao.getUsername()

        //Criando numeros randoms para preencher o numero da conta
        var accNumber = (10000..99999).random()

        // Iniciando a conta com um valor fixo
        var balance = 1.453

        if (listOfUsers.contains(username)) {
            println("Nome de usuario ja registrado")
        }else if (password != passwordVerify){
            println("A senha informada não é semelhante")
        }else if (password.isEmpty() || password.isBlank()){
            println("Por favor insira uma senha valida e sem espaços")
        }else if (username.isEmpty()|| username.isBlank()){
            println("Por favor, insira um nome valido e sem espaços")
        }else{
            userDao.RegisterUser(User(username, password, balance, accNumber))
            println("Usuario cadastrado")
        }
    }
}