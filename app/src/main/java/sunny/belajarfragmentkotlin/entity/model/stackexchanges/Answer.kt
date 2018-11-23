package sunny.testrequestsample

import java.io.Serializable
import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import sunny.kotlinmoviechart.entity.model.Item

class Answer : Serializable {

    @SerializedName("items")
    @Expose
    var items: List<Item> = ArrayList<Item>()
    @SerializedName("has_more")
    @Expose
    var hasMore: Boolean? = null
    @SerializedName("backoff")
    @Expose
    var backoff: Int? = null
    @SerializedName("quota_max")
    @Expose
    var quotaMax: Int? = null
    @SerializedName("quota_remaining")
    @Expose
    var quotaRemaining: Int? = null

    companion object {
        private const val serialVersionUID = -3181568046297244782L
    }

}