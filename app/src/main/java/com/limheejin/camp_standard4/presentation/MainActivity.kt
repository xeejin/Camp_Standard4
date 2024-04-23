package com.limheejin.camp_standard4.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.limheejin.camp_standard4.adapter.CardAdapter
import com.limheejin.camp_standard4.data.CardList
import com.limheejin.camp_standard4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val cardList = CardList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
    }


    private fun setRecyclerView() { // 리사이클러뷰 설정
        binding.rvRecyclerview.adapter = CardAdapter(cardList)
        // xml 리사이클러뷰의 어댑터로 위에서 만든 어댑터 설정
        binding.rvRecyclerview.layoutManager = LinearLayoutManager(this)
        // xml 리사이클러뷰의 레이아웃 매니저 설정
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