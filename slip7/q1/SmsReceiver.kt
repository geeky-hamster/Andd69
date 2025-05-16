// b) Receive SMS
// Note: You must add RECEIVE_SMS and READ_SMS permissions in AndroidManifest.xml
// and register the receiver in the manifest.

package com.example.receivesmsdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras
        if (bundle != null) {
            val pdus = bundle.get("pdus") as Array<*>
            for (pdu in pdus) {
                val format = bundle.getString("format")
                val sms = SmsMessage.createFromPdu(pdu as ByteArray, format)
                val message = sms.messageBody
                val sender = sms.originatingAddress
                Toast.makeText(context, "SMS from $sender: $message", Toast.LENGTH_LONG).show()
            }
        }
    }
}
