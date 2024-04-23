package com.limheejin.camp_standard4.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.limheejin.camp_standard4.adapter.CardAdapter
import com.limheejin.camp_standard4.data.CardList
import com.limheejin.camp_standard4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private val cardList = CardList()
    // view모델 연결
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModelFactory()
    }

    private val cardAdapter by lazy { CardAdapter(cardViewModel.cardsLiveData)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvRecyclerview.adapter = cardAdapter
        binding.rvRecyclerview.layoutManager = LinearLayoutManager(this)

//        setRecyclerView()
    }



//    private fun setRecyclerView() { // 리사이클러뷰 설정
//        binding.rvRecyclerview.adapter = CardAdapter
//        // xml 리사이클러뷰의 어댑터로 위에서 만든 어댑터 설정
//        binding.rvRecyclerview.layoutManager = LinearLayoutManager(this)
//        // xml 리사이클러뷰의 레이아웃 매니저 설정
    }

//    private fun adapterOnClick(card : Card) {
//        //bundle로 넘기는작업
//        val intent = Intent(this, DetailActivity::class.java)
//        val bundle = Bundle().apply{
//            putParcelable(DetailActivity.EXTRA_CARD, card)
//        }
//        intent.putExtra(bundle)
//        startActivity(intent)
//    }

}



