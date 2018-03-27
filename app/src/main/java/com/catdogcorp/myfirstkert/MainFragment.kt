package com.catdogcorp.myfirstkert

import android.arch.persistence.room.Room
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catdogcorp.myfirstkert.db.History
import com.catdogcorp.myfirstkert.db.HistoryDataBase
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*


class MainFragment : Fragment(),MainFragmentView, MyHolder.callback {


    private var myAdapter: MyAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var presenter : MainFragmentPresenterIml? = null
    private lateinit var database: HistoryDataBase

    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = MainFragmentPresenterIml(this)
        super.onCreate(savedInstanceState)

        database = Room.databaseBuilder(context,
                HistoryDataBase::class.java, "scores.db")
                .allowMainThreadQueries()
                .build()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.main_fragment, container, false)
        recyclerView = view!!.findViewById(R.id.card_view)
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        myAdapter = MyAdapter(context, presenter!!.getRandomData(), presenter!!.numberOfColumns )
        myAdapter!!.setCallback(this)
        recyclerView!!.adapter = myAdapter
        recyclerView!!.layoutManager = GridLayoutManager(activity, presenter!!.numberOfColumns)
    }


    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // TODO: Rename and change types and number of parameters
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onItemClickListener(num: Int, step: Int) {
        showHint(num)
        if (step == 1) {
            presenter!!.startTimer()
        }

        if (step == 50) {
            presenter!!.stopTimer()
            showYourScore(presenter!!.getGameResult())
            database.HistoryDAO().updateScores(History(database.HistoryDAO().getScoreList().size+ 1, Date().toString(), presenter!!.getGameResult()))
        }
    }

    override fun newGame() {
        initRecyclerView()
        resetUI()
        presenter!!.stopTimer()
    }

    override fun showTimer(num: String) {
        tx_timers.text = num
    }

    override fun showHint(num : Int) {
        tx_hint.text = num.toString()
    }

    override fun showYourScore(num: String) {
        tx_result2.visibility = View.VISIBLE
        tx_result2.text = tx_result2.text.toString() + num
    }

    override fun resetUI() {
        showHint(1)
        showTimer("0:0")
        tx_result2.visibility = View.INVISIBLE

    }
}// Required empty public constructor
