package ae.astratech.nfcreader.data.model

data class ScanRecord(
    val id: String,
    val tagId: String,
    val tagType: NfcTagType,
    val timestamp: Long,
    val result: String
)