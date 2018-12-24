package com.arivista.biomarticlogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.arivista.biomarticlogin.support.BiometricCallback
import com.arivista.biomarticlogin.support.BiometricManager


class MainActivity : AppCompatActivity(), BiometricCallback {

    //  private Button button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        BiometricManager.BiometricBuilder(this@MainActivity)
            .setTitle(getString(R.string.biometric_title))
            .setSubtitle(getString(R.string.biometric_subtitle))
            .setDescription(getString(R.string.biometric_description))
            .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
            .build()
            .authenticate(this@MainActivity)
    }


    override fun onSdkVersionNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG)
            .show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_hardware_not_supported),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_fingerprint_not_available),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(
            applicationContext,
            getString(R.string.biometric_error_permission_not_granted),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        //        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(applicationContext, getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(applicationContext, getString(R.string.biometric_success), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        //        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        //        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}