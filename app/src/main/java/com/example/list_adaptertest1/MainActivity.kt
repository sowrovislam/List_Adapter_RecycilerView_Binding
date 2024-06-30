package com.example.list_adaptertest1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list_adaptertest1.databinding.ActivityMainBinding
import com.example.list_adaptertest1.reciclerview.adapter.AdapterRec
import com.example.list_adaptertest1.reciclerview.dataclass.DataClass

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var adapterRec: AdapterRec

    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        adapterRec= AdapterRec()

        val p1= DataClass(1,"Sowrov Islam","I am A Student")

        val p2= DataClass(2,"DF","QW")

        val p3= DataClass(3,"FD","SA")

        val p4= DataClass(4,"TY","SAS")

        val p5= DataClass(5,"AS","KJ")

        adapterRec.submitList(listOf(p1,p2,p3,p4,p5))






        binding.recycilerView.layoutManager=LinearLayoutManager(this)
        binding.recycilerView.setHasFixedSize(true)
         binding.recycilerView.adapter=adapterRec

        Handler(Looper.getMainLooper()).postDelayed({

            val p6= DataClass(6," A"," Student")

            val p7= DataClass(7,"B","I am")

            val p8= DataClass(8,"C"," A Student")

            val p9= DataClass(9,"D","I Student")

            val p10= DataClass(10,"F","I am A Student")

            adapterRec.submitList(listOf(p6,p7,p8,p9,p10))




        },4000)













    }
}