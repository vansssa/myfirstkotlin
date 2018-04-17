package com.catdogcorp.myfirstkert

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.idescout.sql.SqlScoutServer
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    lateinit var fragmentView: MainFragment
    lateinit var historyFragment: HistoryFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SqlScoutServer.create(this, packageName)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fragmentView = MainFragment.newInstance()
        historyFragment = HistoryFragment.newInstance()
        fab.setOnClickListener {
            fragmentView.newGame()
        }
    }


    override fun onResume() {
        super.onResume()
        if (!fragmentView.isAdded) {
            supportFragmentManager.inTransaction {
                add(R.id.main_fragment, fragmentView, "mainFragment")
            }
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

            R.id.action_history -> {
                launchHistoryFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun launchHistoryFragment() {
        fab.visibility = View.GONE
        supportFragmentManager.inTransaction {
            if(fragmentView.isAdded)
                hide(fragmentView)
            add(R.id.main_fragment,  historyFragment , "HistoryFragment")

        }
    }
}
