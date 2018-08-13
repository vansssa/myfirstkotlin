package com.catdogcorp.myfirstkert

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import com.catdogcorp.myfirstkert.db.DatabaseTaskSync
import com.catdogcorp.myfirstkert.db.History


// TODO: Rename parameter arguments, choose names that match


class HistoryFragment : Fragment() ,DatabaseTaskSync.Callback{
    override fun onTaskDone(result: ArrayList<History>) {
        initRecyclerView(result)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var historyAdaper: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_history, container, false)

        recyclerView = view.findViewById(R.id.history_recyclerView)
        DatabaseTaskSync(context, this).execute()
        setHasOptionsMenu(true)
        return view
    }

    private fun initRecyclerView(result: ArrayList<History>) {
        historyAdaper = HistoryAdapter(context,result)
        recyclerView!!.adapter = historyAdaper
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu?.clear()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                HistoryFragment().apply {
                }
    }


}
