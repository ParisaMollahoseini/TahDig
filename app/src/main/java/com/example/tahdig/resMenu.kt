package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_res_menu.*
import java.sql.SQLException

class resMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_menu)
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)

        menu_add.setOnClickListener {

            if (food_name.text.isNotEmpty() && price.text.isNotEmpty() && amount.text.isNotEmpty()) {
                itemlist.add(
                    food_name.text.toString() + "," + price.text.toString() + "," +
                            amount.text.toString()
                )

                menu_listView.adapter = adapter


                }

                adapter.notifyDataSetChanged()
                food_name.text.clear()
                price.text.clear()
                amount.text.clear()

        }
        menu_delete.setOnClickListener {
            val position: SparseBooleanArray = menu_listView.checkedItemPositions
            val count = menu_listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item)) {


                        adapter.remove(itemlist.get(item))


                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()


        }

        menu_accept.setOnClickListener {
            ///delete table menu

            ///delete table menu
                for (i in 0 until menu_listView.count-1)
                {
                    val foodname = itemlist.get(i).substringBefore(',')
                    val price = itemlist.get(i).substringAfter(',').substringBefore(',')
                    val amount = itemlist.get(i).substringAfter(foodname+","+price+",").substringBefore(',')
                    ///add to database

                    ///add to database
                }
        }
    }
}