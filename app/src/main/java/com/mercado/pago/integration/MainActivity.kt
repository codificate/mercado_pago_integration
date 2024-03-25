package com.mercado.pago.integration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            viewModel.preferencesState
                .filterNotNull()
                .collectLatest { preferences ->
                    val url = preferences.initPoint
                    val intent = CustomTabsIntent.Builder().build()
                    intent.launchUrl(this@MainActivity, Uri.parse(url))
                }

            viewModel.subscriptionState
                .filterNotNull()
                .collectLatest { subscription ->
                    val url = subscription.initPoint
                    val intent = CustomTabsIntent.Builder().build()
                    intent.launchUrl(this@MainActivity, Uri.parse(url))
                }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val parameters = mutableMapOf<String, String>()
        if (intent?.action == Intent.ACTION_VIEW) {
            val data = intent.data
            data?.queryParameterNames?.forEach { parameter ->
                val value = data.getQueryParameter(parameter)
                parameters[parameter] = value.orEmpty()
            }

            Log.d(TAG, parameters.toString())
            /*
            data?.let {
                val status = data.getQueryParameter("status")
                val collectionStatus = data.getQueryParameter("collection_status")
                val preferenceId = data.getQueryParameter("preference_id")
                val siteId = data.getQueryParameter("site_id")
                val externalReference = data.getQueryParameter("external_reference")
                val merchantOrderId = data.getQueryParameter("merchant_order_id")
                val collectionId = data.getQueryParameter("collection_id")
                val paymentId = data.getQueryParameter("payment_id")
                val paymentType = data.getQueryParameter("payment_type")
                val processingMode = data.getQueryParameter("processing_mode")

                Log.d(TAG, "Status: $status")
                Log.d(TAG, "Collection Status: $collectionStatus")
                Log.d(TAG, "Preference ID: $preferenceId")
                Log.d(TAG, "Site ID: $siteId")
                Log.d(TAG, "External Reference: $externalReference")
                Log.d(TAG, "Merchant Order ID: $merchantOrderId")
                Log.d(TAG, "Collection ID: $collectionId")
                Log.d(TAG, "Payment ID: $paymentId")
                Log.d(TAG, "Payment Type: $paymentType")
                Log.d(TAG, "Processing Mode: $processingMode")
            }
             */
        }
    }
}