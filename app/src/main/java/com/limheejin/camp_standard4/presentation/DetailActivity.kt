package com.limheejin.camp_standard4.presentation

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.limheejin.camp_standard4.data.CardData
import com.limheejin.camp_standard4.data.priceDecimal
import com.limheejin.camp_standard4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }
    private val cardId = EXTRA_CARD

//    private val selectedCard by lazy {
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
//            intent.getParcelableExtra("CardData", CardData::class.java)
//        } else {
//            intent.getParcelableExtra("CardData")
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        selectedCard?.let {
//            binding.tvName.text = it.name
//            binding.tvCardNumber.text = it.cardNumber
//            binding.tvExpDate.text = it.expDate
//            binding.tvPrice.text = priceDecimal(it.price)
//        }

        val card = cardViewModel.getCardForId(cardId)
            binding.tvName.text = card.name
            binding.tvCardNumber.text = card.cardNumber
            binding.tvExpDate.text = card.expDate
            binding.tvPrice.text = priceDecimal(card.price)

    }
}