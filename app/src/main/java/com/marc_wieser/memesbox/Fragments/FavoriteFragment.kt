package com.marc_wieser.memesbox.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marc_wieser.memesbox.MainActivity
import com.marc_wieser.memesbox.R


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    private fun updateFragmentVisibility(loggedIn: Boolean, view:View? = this.view){
        if (loggedIn){
            view?.findViewById(R.id.regular_fragment)?.visibility = View.VISIBLE
            view?.findViewById(R.id.not_connected_error)?.visibility = View.GONE
        } else {
            view?.findViewById(R.id.regular_fragment)?.visibility = View.GONE
            view?.findViewById(R.id.not_connected_error)?.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_liked, container, false)
        (activity as MainActivity).registerFirebaseAuthentificationUpdates {
            updateFragmentVisibility(it)
        }
        updateFragmentVisibility((activity as MainActivity).fireAuth?.currentUser != null, v)
        v.findViewById(R.id.login).setOnClickListener {
            (activity as MainActivity).startLoginFlow()
        }
        return v
    }

}
