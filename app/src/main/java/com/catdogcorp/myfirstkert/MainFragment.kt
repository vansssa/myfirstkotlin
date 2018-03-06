package com.catdogcorp.myfirstkert

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class MainFragment : Fragment() {

    private var myAdapter: MyAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var presenter : MainFragmentPresenterIml? = null

    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = MainFragmentPresenterIml()
        super.onCreate(savedInstanceState)
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
            val fragment = MainFragment()
            return fragment
        }
    }
}// Required empty public constructor
