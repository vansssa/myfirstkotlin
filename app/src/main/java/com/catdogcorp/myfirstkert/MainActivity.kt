package com.catdogcorp.myfirstkert

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            newGame()
        }

    }

    private fun newGame() {
        TODO("stoptimer")
        TODO("reload game")
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.inTransaction {
            add(R.id.main_fragment,  MainFragment.newInstance())
        }
    }

    // FragmentManager attachment.
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        //val fragmentTransaction = beginTransaction()
        //fragmentTransaction.func()
        //fragmentTransaction.commit()
        beginTransaction().func().commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_history -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
