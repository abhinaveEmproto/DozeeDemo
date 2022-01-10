package com.example.tvdemoapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvdemoapp.R
import com.example.tvdemoapp.adapter.DetailAdapter
import com.example.tvdemoapp.dataModel.WardInfoDataModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*

class DashboardActivity : FragmentActivity() {

    lateinit var lineChart:LineChart
    lateinit var piechart:PieChart
    lateinit var recyclerView: RecyclerView
    lateinit var logOutBtn:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        logOutBtn= findViewById(R.id.log_out_btn)
        lineChart= findViewById(R.id.line_chart)
        piechart= findViewById(R.id.pie_chart)

        recyclerView= findViewById(R.id.detail_recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)

        var detailAdapter= DetailAdapter(dataModelList())
        recyclerView.adapter= detailAdapter

        logOutBtn.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        })

        get_line_data()
        get_pie_data()

    }

     private fun dataModelList():ArrayList<WardInfoDataModel> {

        val itemList:ArrayList<WardInfoDataModel> = ArrayList<WardInfoDataModel>()
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))
         itemList.add(WardInfoDataModel("Rohit","ICCU",6,"1h","High,4",98,31,"--"))

         Log.i("Successfull","Successfull")
         return itemList
     }

    private fun dataValue1():ArrayList<Entry> {
        var dataVal:ArrayList<Entry> = ArrayList()
        dataVal.add(Entry(11/10F, 0F))
        dataVal.add(Entry(13/10F, 50F))
        dataVal.add(Entry(15/10F, 20F))
        dataVal.add(Entry(17/10F, 150F))
        dataVal.add(Entry(19/10F, 200F))
        dataVal.add(Entry(21/10F, 50F))
        dataVal.add(Entry(24/10F, 320F))
        dataVal.add(Entry(26/10F, 200F))
        return dataVal
    }

    private fun dataValue2():ArrayList<PieEntry>{
        var dataVal:ArrayList<PieEntry> = ArrayList()
        dataVal.add(PieEntry(500f,"2018"))
        dataVal.add(PieEntry(600f,"2019"))
        dataVal.add(PieEntry(370f,"2020"))
        dataVal.add(PieEntry(180f,"2021"))
        dataVal.add(PieEntry(580f,"2017"))
        dataVal.add(PieEntry(230f,"2022"))
        return dataVal
    }

    private fun get_line_data(){
        var lineDataSet = LineDataSet(dataValue1(),"Data set 1")
        var dataSets:ArrayList<LineDataSet> = ArrayList()
        dataSets.add(lineDataSet)

        var data:LineData = LineData(lineDataSet)
        lineChart.setData(data)
        lineChart.invalidate()
        lineChart.getXAxis().setDrawGridLines(false)
        lineChart.description.setText("")
        lineChart.getLegend().setEnabled(false)
        lineChart.getAxisRight().setEnabled(false)
        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER)
        lineDataSet.setDrawFilled(true)
        lineDataSet.setFillColor(Color.RED)
        lineDataSet.setColors(Color.RED)
    }
    private fun get_pie_data(){
        var pieDataSet = PieDataSet(dataValue2(), "Data set 2")
        var dataSets:ArrayList<PieDataSet> = ArrayList()
        pieDataSet.setColors(Color.RED)
        dataSets.add(pieDataSet)

        var data = PieData(pieDataSet)
        piechart.setData(data)
        piechart.setCenterText("Visitors")

    }




}