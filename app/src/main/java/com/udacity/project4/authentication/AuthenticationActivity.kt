package com.udacity.project4.authentication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.AuthUI.IdpConfig.EmailBuilder
import com.firebase.ui.auth.AuthUI.IdpConfig.GoogleBuilder
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.udacity.project4.R
import com.udacity.project4.locationreminders.RemindersActivity
import kotlinx.android.synthetic.main.activity_authentication.*
import java.util.*


/**
 * This class should be the starting point of the app, It asks the users to sign in / register, and redirects the
 * signed in users to the RemindersActivity.
 */
class AuthenticationActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 123
    private val TAG = "SIGN_IN_MSG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        val auth = FirebaseAuth.getInstance()
        login.setOnClickListener(View.OnClickListener {
            if (auth.currentUser != null) {
                val intent = Intent(this@AuthenticationActivity, RemindersActivity::class.java);
                startActivity(intent);
            } else {
                startActivityForResult(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(
                            Arrays.asList(
                                GoogleBuilder().build(),
                                EmailBuilder().build()
                            )
                        )
                        .build(),
                    RC_SIGN_IN
                )
            }
        })
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            // Successfully signed in
            if (resultCode == Activity.RESULT_OK) {
                val intent = Intent(this@AuthenticationActivity, RemindersActivity::class.java);
                startActivity(intent);
                finish()
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        R.string.sign_in_cancelled,
                        Snackbar.LENGTH_SHORT
                    ).show()
                    return
                }
                if (response.error!!.errorCode == ErrorCodes.NO_NETWORK) {
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        R.string.no_internet_connection,
                        Snackbar.LENGTH_SHORT
                    ).show()
                    return
                }
                Snackbar.make(
                    findViewById(android.R.id.content),
                    R.string.unknown_error,
                    Snackbar.LENGTH_SHORT
                ).show()
                Log.e(TAG, "Sign-in error: ", response.error)
            }
        }
    }
}
