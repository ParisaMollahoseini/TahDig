package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import java.sql.SQLException

class resMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_menu)
//        Add.setOnClickListener {
//            if (state_id.text.isNotEmpty() and tot_cost.text.isNotEmpty()) {
//                itemlist.add(
//                    state_id.text.toString() + "," + exp_date.text.toString() + "," +
//                            exp_desc.text.toString() + "," + tot_cost.text.toString()
//                )
//
//                listView.adapter = adapter
//                ////database
//                try {
//                    var exp_date1: String = "(select getdate())"
//                    if (exp_date.text.isNotEmpty())
//                        exp_date1 = "'" + exp_date.text.toString() + "'"
//
//                    var exp_desc1: String = "NULL"
//                    if (exp_desc.text.isNotEmpty())
//                        exp_desc1 = "'" + exp_desc.text.toString() + "'"
//
//                    val con = connectionClass.CONN()
//                    val stmt = con.createStatement()
//                    val query =
//                        "insert into expenses(state_id,exp_date,exp_desc,tot_cost) values(" +
//                                state_id.text.toString() + "," + exp_date1 + "," +
//                                exp_desc1 + "," + tot_cost.text.toString() + ")"
//                    Log.println(Log.INFO, "query", query)
//                    stmt.executeUpdate(query)
//                } catch (se: SQLException) {
//                    Log.e("ERROR", se.message)
//                    android.widget.Toast.makeText(
//                        this,
//                        se.message.toString(),
//                        android.widget.Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//
//                ///database
//                adapter.notifyDataSetChanged()
//                state_id.text.clear()
//                exp_date.text.clear()
//                exp_desc.text.clear()
//                tot_cost.text.clear()
//            }
//        }
//        delete.setOnClickListener {
//            val position: SparseBooleanArray = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//            while (item >= 0) {
//                if (position.get(item)) {
//
//                    ////database
//                    try {
//                        val con = connectionClass.CONN()
//                        val stmt = con.createStatement()
//                        val query = "delete from expenses where state_id=" + itemlist.get(item)
//                            .substringBefore(',')
//                        Log.println(Log.INFO, "query", query)
//                        stmt.executeUpdate(query)
//                        adapter.remove(itemlist.get(item))
//                    } catch (se: SQLException) {
//                        Log.e("ERROR", se.message)
//                        android.widget.Toast.makeText(
//                            this,
//                            se.message.toString(),
//                            android.widget.Toast.LENGTH_SHORT
//                        ).show()
//
//                    }
//
//                    ///database
//
//                }
//                item--
//            }
//            position.clear()
//            adapter.notifyDataSetChanged()
//
//
//        }
//
//        update.setOnClickListener {
//            val position: SparseBooleanArray = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//
//            var st_id = state_id.hint.toString()
//
//            var exp_d = exp_date.hint.toString().toUpperCase()
//            lateinit var exp_desc1: String
//            if (exp_desc.hint.toString() == "null")
//                exp_desc1 = "NULL"
//            else
//                exp_desc1 = exp_desc.hint.toString()
//            var cost = tot_cost.hint.toString().toUpperCase()
//
//            while (item >= 0) {
//                if (position.get(item)) {
//                    if (state_id.text.isNotEmpty()) {
//                        st_id = state_id.text.toString()
//                    }
//                    if (exp_date.text.isNotEmpty()) {
//                        exp_d = exp_date.text.toString()
//                    }
//                    if (exp_desc.text.isNotEmpty()) {
//                        exp_desc1 = exp_desc.text.toString()
//                    }
//                    if (tot_cost.text.isNotEmpty()) {
//                        cost = tot_cost.text.toString()
//                    }
//                    ////database
//                    try {
//                        val con = connectionClass.CONN()
//                        val stmt = con.createStatement()
//                        val query =
//                            "update expenses set state_id=" + st_id + ",exp_date='" + exp_d + "',exp_desc='" + exp_desc1 + "',tot_cost=" + cost + " where state_id=" + state_id.hint.toString()
//                        Log.println(Log.INFO, "query", query)
//                        stmt.executeUpdate(query)
//                        adapter.remove(itemlist.get(item))
//                        itemlist.add(
//                            st_id + "," + exp_d + "," +
//                                    exp_desc1 + "," + cost
//                        )
//                    } catch (se: SQLException) {
//                        Log.e("ERROR", se.message)
//                        android.widget.Toast.makeText(
//                            this,
//                            se.message.toString(),
//                            android.widget.Toast.LENGTH_SHORT
//                        ).show()
//
//                    }
//
//                    ///database
//
//
//                }
//                item--
//            }
//
//            position.clear()
//            adapter.notifyDataSetChanged()
//
//        }
  }
}
