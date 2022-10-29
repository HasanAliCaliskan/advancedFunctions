package com.hasanali.kotlinadvancedfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity(), LifecycleLogger by LifecycleLoggerImplementation() {


    // property delegation
    private val myVariable by lazy {
        // myVariable bir yerde kullanılmazsa alttaki işlemler yapılmaz.
        println("this is a lazy implementation")
        10
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerLifecycleOwner(this)
    }

}



interface LifecycleLogger {

    fun registerLifecycleOwner(owner: LifecycleOwner)
}


class LifecycleLoggerImplementation : LifecycleLogger, LifecycleEventObserver {

    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        // Yazdığımız LifecycleLogger'dan bir metodu override ediyor.
        // Lifecycle'ı gözlemlemek için aldığımız LifecycleOwner'a "addObserver" ile observer ekliyoruz.
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        // LifecycleEventObserver interface'inin bu metodu sayesinde değişen event'leri alıp işlemler yapabiliriz.
        when(event) {
            Lifecycle.Event.ON_CREATE -> println("onCreate")
            Lifecycle.Event.ON_DESTROY -> println("onDestroy")
            Lifecycle.Event.ON_RESUME -> println("onResume")
            else -> Unit
        }
    }
}


