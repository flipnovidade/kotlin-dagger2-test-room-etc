package br.com.test.claro.net.embratel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Shots: Serializable {
    private var id: Int = 0

    private var title: String? = null

    private var description: String? = null

    @SerializedName("views_count")
    private var viewsCount: Int = 0

    @SerializedName("likes_count")
    private var likesCount: Int = 0

    @SerializedName("comments_count")
    private var commentCount: Int = 0
}