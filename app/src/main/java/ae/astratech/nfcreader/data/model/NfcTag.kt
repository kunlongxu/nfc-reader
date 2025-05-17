package ae.astratech.nfcreader.data.model

data class NfcTag (
    val id: String,
    val type: NfcTagType,
    val data: Map<String, Any>
)