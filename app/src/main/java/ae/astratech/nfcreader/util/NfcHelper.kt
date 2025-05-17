package ae.astratech.nfcreader.util

import ae.astratech.nfcreader.data.model.NfcTag
import ae.astratech.nfcreader.data.model.NfcTagType
import android.content.Context
import android.nfc.NfcAdapter
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.channels.awaitClose
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NfcHelper @Inject constructor(private val context: Context) {
    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(context)
    }

    fun isNfcAvailable(): Boolean = nfcAdapter != null

    fun isNfcEnabled(): Boolean = nfcAdapter?.isEnabled == true

    suspend fun readTag(): Flow<NfcTag> = callbackFlow {
        val testTag = NfcTag(
            id = "123456789",
            type = NfcTagType.CARD_BALANCE,
            data = mapOf("balance" to 100.0)
        )

        trySend(testTag)

        awaitClose {
            Log.d("NfcHelper", "Closing flow")
        }
    }
}