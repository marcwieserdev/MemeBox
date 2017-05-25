package com.marc_wieser.memesbox

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ResultCodes
import com.google.firebase.auth.FirebaseAuth
import com.marc_wieser.memesbox.Adapters.PagerAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    val RC_SIGN_IN: Int = 4242
    var firebaseAuthCallbacks : Array<(loggedIn: Boolean)->Unit> = Array<(Boolean)->Unit>(0, {{}})
    var fireAuth : FirebaseAuth? = null

    private fun updateLoginGraphicsMenu(menu: Menu): Unit{
        if (fireAuth?.currentUser != null){
            menu.findItem(R.id.menu_login).isVisible = false
            menu.findItem(R.id.menu_logout).isVisible = true
        } else {
            menu.findItem(R.id.menu_login).isVisible = true
            menu.findItem(R.id.menu_logout).isVisible = false
        }
    }

    fun registerFirebaseAuthentificationUpdates(call: (loggedIn: Boolean) -> Unit){
        firebaseAuthCallbacks += call
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fireAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_main)
        val pager : ViewPager = findViewById(R.id.pager) as ViewPager
        pager.adapter = PagerAdapter(supportFragmentManager, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)

        if (menu != null)
            updateLoginGraphicsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_login -> {
                startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                        .setProviders(Arrays.asList(
                                AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()))
                        .build(), RC_SIGN_IN)
            }
            R.id.menu_logout -> {
                AuthUI.getInstance().signOut(this).addOnCompleteListener {
                    invalidateOptionsMenu()
                    firebaseAuthCallbacks.forEach { it(false) }
                }
            }
            else -> throw UnsupportedOperationException()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SIGN_IN && resultCode == ResultCodes.OK){
            invalidateOptionsMenu()
            firebaseAuthCallbacks.forEach { it(true) }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
