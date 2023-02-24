package com.example.silversbank.utils.RecyclerView

import com.example.silversbank.utils.RecyclerView.News

class NewsData {
    companion object{
        fun listNews() : ArrayList<News>{
            val newsList = ArrayList<News>()

            newsList.add(
                News(
                    "Cartão fidelidade",
                    "Um novo benecio para você, o Cartão Fidelidade lhe garante diversos benecios para empresas parceiras, como: desconto em viagens nacionais, juros anulado ao comprar um veiculo da categoria"
            )
            )

            newsList.add(
                News(
                    "Negocie suas dividas",
                    "Sabemos que a correria do dia a dia pode dificultar as coisas, então não deixe de organizar suas dividas. Clique aqui para mais informações"
                )
            )

            newsList.add(
                News(
                    "Silver's Life",
                    "No mundo atual, não podemos deixar a nossa saude de lado, o Silver's Bank oferece um plano de saude exclusivo para os nossos clientes."
                )
            )


            newsList.add(
                News(
                    "Cadastro de Biometria",
                    "O cadastro biometrico já esta disponivel em nosso aplicativo, conheça as principais vantagens de usar a biometria."
                )
            )

            newsList.add(
                News(
                    "https://github.com/Math012",
                    ":)"
                )
            )

            return newsList
        }
    }
}