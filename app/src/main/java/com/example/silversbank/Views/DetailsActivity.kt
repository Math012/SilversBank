package com.example.silversbank.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.database.AppDataBase
import com.example.silversbank.databinding.ActivityDetalhesBinding
import com.example.silversbank.adapters.NewsAdapter
import com.example.silversbank.utils.RecyclerView.NewsData

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao

    private lateinit var adapterNews: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        dataBase = AppDataBase.getDao(this)
        userDao = dataBase.userDao()

        initAdapter()
        initListRecycler()

        val usernameReturn = intent.getStringExtra("username")!!
        Thread(Runnable {
            toViewUser(usernameReturn)
        }).start()

        binding.btPay.setOnClickListener {
            intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initAdapter() {
        adapterNews = NewsAdapter()
        binding.recyclerViewNews.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewNews.adapter = adapterNews
    }

    private fun initListRecycler() {
        val totalNews = NewsData.listNews()
        adapterNews.addListNews(totalNews)
    }

    private fun toViewUser(username:String) {
        var userOn = userDao.getAccountUser(username)
        val convertType = userOn.balance.toString()
        binding.textWelcome.setText("Bem vindo, ${userOn.username}")
        binding.textBalanceValue.setText("RS: ${convertType}")

    }
}

//fun getAccountUser(username:String):User