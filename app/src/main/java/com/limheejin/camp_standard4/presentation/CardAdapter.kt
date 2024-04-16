package com.limheejin.camp_standard4.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limheejin.camp_standard4.data.CardData
import com.limheejin.camp_standard4.data.priceDecimal
import com.limheejin.camp_standard4.databinding.ItemCard1Binding
import com.limheejin.camp_standard4.databinding.ItemCard2Binding
import com.limheejin.camp_standard4.databinding.ItemCard3Binding

class CardAdapter(private val cardItems: List<CardData>) : // 어댑터 객체를 생성할 때, 만들어놓은 데이터 클래스를 인수로 받아줌
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {  // RecyclerView.Adapter<아래에 만들 뷰홀더 클래스>를 상속 (뷰홀더 패턴으로 구현)

        interface ItemClick {
            fun onClick(view: View, position: Int)
        }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 위에서 만든 뷰홀더의 객체를 생성하는 부분, 10번 정도 실행되고 안 됨
        // 아이템을 담은 xml의 뷰 바인딩 객체 생성
        return when(viewType){
                TYPE_1 -> {
                    val binding = ItemCard1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                    MultiViewHolder1(binding)
                }
                TYPE_2 -> {
                    val binding = ItemCard2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                    MultiViewHolder2(binding)
                }
                else -> {
                    val binding = ItemCard3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                    MultiViewHolder3(binding)
                }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { // 정보를 바인딩 하는 부분. 처음 어댑터 객체를 생성할 때 인수로 받은 데이터를, 위의 뷰홀더 객체에 어떻게 넣어줄지 결정하는 부분
       //포지션은 리스트에서 어느 위치에 있는지

        var currentItem = cardItems[position]

            holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }

        when(holder.itemViewType){
            TYPE_1 -> {
                (holder as MultiViewHolder1).bind(cardItems[position])
                val viewHolder = holder as MultiViewHolder1
                viewHolder.bind(currentItem)
            }
            TYPE_2 -> {
                (holder as MultiViewHolder2).bind(cardItems[position])
                val viewHolder = holder as MultiViewHolder2
                viewHolder.bind(currentItem)
            }
            TYPE_3 -> {
                (holder as MultiViewHolder3).bind(cardItems[position])
                val viewHolder = holder as MultiViewHolder3
                viewHolder.bind(currentItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position)
        {
            0 -> TYPE_1
            1 -> TYPE_2
            2 -> TYPE_3
            else -> {
                TYPE_1}
        }
    }

    override fun getItemCount(): Int { // 데이터가 몇 개인지 변환
        // 리사이클러뷰 아이템 개수는 데이터 리스트의 크기
        return cardItems.size
    }
    // 간단하게 override fun getItemCount(): Int = cardItems.size 한 줄짜리 코드로 입력해도 됨

    inner class MultiViewHolder1(private val binding: ItemCard1Binding) : // 뷰홀더 클래스를 생성, RecyclerView.ViewHolder 클래스를 상속함. binding: 아이템xml이름 + Binding
        RecyclerView.ViewHolder(binding.root) {

        // 뷰 바인딩에서 기본적으로 제공하는 root 변수는 레이아웃의 루트 레이아웃을 의미
        fun bind(card: CardData){
            val context = binding.root.context //안티패턴이라 지워야됨

            binding.tvName.text = card.name
            binding.tvCardNumber.text = card.cardNumber
            binding.tvExpDate.text = card.expDate
            binding.tvPrice.text = priceDecimal(card.price)

            binding.itemCard1.setOnClickListener { // 액티비티에서 구현해야 함
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("CardData", card)
                context.startActivity(intent)
            }

        }
    }

    inner class MultiViewHolder2(private val binding: ItemCard2Binding) : // 뷰홀더 클래스를 생성, RecyclerView.ViewHolder 클래스를 상속함. binding: 아이템xml이름 + Binding
        RecyclerView.ViewHolder(binding.root) {

        // 뷰 바인딩에서 기본적으로 제공하는 root 변수는 레이아웃의 루트 레이아웃을 의미
        fun bind(card: CardData){
            val context = binding.root.context //안티패턴이라 지워야됨

            binding.tvName.text = card.name
            binding.tvCardNumber.text = card.cardNumber
            binding.tvExpDate.text = card.expDate
            binding.tvPrice.text = priceDecimal(card.price)

            binding.itemCard2.setOnClickListener { // 액티비티에서 구현해야 함
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("CardData", card)
                context.startActivity(intent)
            }

        }
    }

    inner class MultiViewHolder3(private val binding: ItemCard3Binding) : // 뷰홀더 클래스를 생성, RecyclerView.ViewHolder 클래스를 상속함. binding: 아이템xml이름 + Binding
        RecyclerView.ViewHolder(binding.root) {

        // 뷰 바인딩에서 기본적으로 제공하는 root 변수는 레이아웃의 루트 레이아웃을 의미
        fun bind(card: CardData){
            val context = binding.root.context //안티패턴이라 지워야됨

            binding.tvName.text = card.name
            binding.tvCardNumber.text = card.cardNumber
            binding.tvExpDate.text = card.expDate
            binding.tvPrice.text = priceDecimal(card.price)

            binding.itemCard3.setOnClickListener { // 액티비티에서 구현해야 함
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("CardData", card)
                context.startActivity(intent)
            }

        }
    }


}