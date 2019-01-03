package com.example.faisal.diceroller.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faisal.diceroller.R
import createLog
import createToast
import hideKeyboard
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {


    //required assets
    //item_list.xml
    //Adapter.kt
    lateinit var adapter : Adapter
    lateinit var layoutManager: LinearLayoutManager

    val animals: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)



        addAnimals()

        layoutManager = LinearLayoutManager(this)
        adapter = Adapter(animals, this , this)

        recycler_list.layoutManager = layoutManager
        recycler_list.adapter = adapter

        setRecyclerViewScrollListener()
        setRecyclerViewItemTouchListener()


        btn_add.setOnClickListener {
            hideKeyboard(this ,root )
            addNew(edt_txt_add.text.toString())
            edt_txt_add.setText("")
        }



    }


    private fun setRecyclerViewScrollListener() {
        recycler_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recycler_list, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount


                val lastItem  = layoutManager.findLastVisibleItemPosition()
                createLog(lastItem.toString())

                if(lastItem == animals.size-1){
                    createLog("we have reached the end !")
                }
            }

        })
    }
    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                animals.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recycler_list)
    }

    fun addNew(name : String){
        animals.add(name)
        adapter.notifyDataSetChanged()
    }


    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }

}
