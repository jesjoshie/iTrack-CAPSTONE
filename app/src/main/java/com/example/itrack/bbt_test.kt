package com.example.itrack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.ArrayList

private val FirebaseFirestore.id: Any
    get() {
      return  true
    }


class bbt_test : AppCompatActivity() {
    lateinit var xValue: EditText
    lateinit var yValue: EditText
    lateinit var insertBtn: Button
    lateinit var lineChart: LineChart

    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var myRef: DatabaseReference
    var lineDataSet = LineDataSet(null, null)
    var iLineDataSets = ArrayList<ILineDataSet>()
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbt_test)

        xValue = findViewById(R.id.xValue)
        yValue = findViewById(R.id.yValue)
        insertBtn = findViewById(R.id.btnInsert)
        lineChart = findViewById(R.id.lineChart)
        firebaseDatabase = FirebaseDatabase.getInstance()
        myRef = firebaseDatabase.getReference("ChartValues")
        insertData()

        /*test*/

      /*  findViewById<Button>(R.id.btnInsert).setOnClickListener {
            insertData()
        }
*/
    }

  /*  private fun insertData() {

        var x = xValue.text.toString().toInt()
        var y = yValue.text.toString().toInt()
        var dataPoint = DataPoint(x,y)
        myRef.setValue(dataPoint)

        retrieveData()
    }

    private fun retrieveData() {

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataVals = ArrayList<Entry>()
                if (dataSnapshot.hasChildren()) {
                    for (myDataSnapshot in dataSnapshot.children) {
                        val dataPoint = myDataSnapshot.getValue(DataPoint::class.java)
                        dataVals.add(Entry(dataPoint!!.getxValue().toFloat(), dataPoint.getyValue().toFloat()))
                    }
                    showChart(dataVals)
                } else {
                    lineChart.clear()
                    lineChart.invalidate()
                }
            }

            override fun onCancelled( error: DatabaseError) {}
        })
    }

    private fun showChart(dataVals: ArrayList<Entry>) {

        lineDataSet.values = dataVals
        lineDataSet.label = ("Data set1")
        iLineDataSets.clear()
        iLineDataSets.add(lineDataSet)
        lineData = LineData(iLineDataSets)
        lineChart.clear()
        lineChart.data = lineData
        lineChart.invalidate()

    }
}*/

/*private fun FirebaseFirestore.addValueEventListener(valueEventListener: ValueEventListener) {
    true
}


private fun Any.setValue(dataPoint: DataPoint) {
    return
}*/

private fun  insertData(){
    insertBtn.setOnClickListener {
        val id = myRef.push().key
        val x = xValue.text.toString().toInt()
        val y = yValue.text.toString().toInt()
        val dataPoint = DataPoint(x,y)
        myRef.setValue(dataPoint)

        retrieveData()
    }
}



private fun retrieveData() {
    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val dataVals = ArrayList<Entry>()
            if (dataSnapshot.hasChildren()) {
                for (myDataSnapshot in dataSnapshot.children) {
                    val dataPoint = myDataSnapshot.getValue(DataPoint::class.java)
                    dataVals.add(Entry(dataPoint!!.getxValue().toFloat(), dataPoint.getyValue().toFloat()))
                }
                showChart(dataVals)
            } else {
                lineChart.clear()
                lineChart.invalidate()
            }
        }

        override fun onCancelled( error: DatabaseError) {}
    })
}

private fun showChart(dataVals: ArrayList<Entry>) {

    lineDataSet.values = dataVals
    lineDataSet.label = ("Data set1")
    iLineDataSets.clear()
    iLineDataSets.add(lineDataSet)
    lineData = LineData(iLineDataSets)
    lineChart.clear()
    lineChart.data = lineData
    lineChart.invalidate()

}
}

private fun FirebaseFirestore.addValueEventListener(valueEventListener: ValueEventListener) {
fun  onDataChange(snapshot: DataSnapshot){
   val  dataVals = ArrayList<Entry>()
   if (snapshot.hasChild()){
       for (myDataSnapshot in snapshot.children){
           val dataPoint = myDataSnapshot.getValue(DataPoint::class.java)
           dataVals.add(Entry(dataPoint!!.getxValue().toFloat(), dataPoint.getyValue().toFloat()))
       }


   }
}
}

private fun DataSnapshot.hasChild(): Boolean {
return true
}

private fun Any.setValue(dataPoint: DataPoint) {


}

private fun FirebaseFirestore.push(): Any {
return  true
}


