package ae.astratech.nfcreader

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NfcReaderApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d("NfcReaderApplication", "Application created")
    }
}