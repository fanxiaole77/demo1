package com.example.myapplication.network

data class Login(
    val password: String,
    val username: String
)

data class Message(
    val code: Int,
    val msg: String,
    val token: String
)

data class Register(
    val avatar: String,
    val email: String,
    val idCard: String,
    val nickName: String,
    val password: String,
    val phonenumber: String,
    val sex: String,
    val userName: String
)

data class HomeBanner(
    val code: String,
    val msg: String,
    val rows: List<Row>,
    val total: String
) {
    data class Row(
        val advImg: String,
        val advTitle: String,
        val id: Int,
        val servModule: String,
        val sort: Int,
        val targetId: Int,
        val type: String
    )
}

data class HomeService(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int
) {
    data class Row(
        val id: Int,
        val imgUrl: String,
        val isRecommend: String,
        val link: String,
        val serviceDesc: String,
        val serviceName: String,
        val serviceType: String,
        val sort: Int
    )
}



data class NewsType(
    val code: Int,
    val msg: String,
    val `data`: List<Row>,
    val total: Int
) {
    data class Row(
        val id: Int,
        val imgUrl: String,
        val name: String,
        val link: String,
        val serviceDesc: String,
        val serviceName: String,
        val serviceType: String,
        val sort: Int
    )
}
data class NewsLIst(
    val code: Int,
    val msg: String,
    val rows: List<Row>,
    val total: Int
) {
    data class Row(
        val commentNum: Int,
        val content: String,
        val cover: String,
        val hot: String,
        val id: Int,
        val likeNum: Int,
        val publishDate: String,
        val readNum: Int,
        val status: String,
        val subTitle: String,
        val tags: Any,
        val title: String,
        val top: String,
        val type: String
    )
}


data class NewsContent(
    val code: Int,
    val `data`: Data,
    val msg: String
) {
    data class Data(
        val appType: String,
        val commentNum: Any,
        val content: String,
        val cover: String,
        val hot: String,
        val id: Int,
        val likeNum: Int,
        val publishDate: String,
        val readNum: Any,
        val status: String,
        val subTitle: String,
        val tags: Any,
        val title: String,
        val top: String,
        val type: String
    )
}

data class UserInfo(
    val code: Int,
    val msg: String,
    val user: User
) {
    data class User(
        val avatar: String,
        val balance: Int,
        val email: String,
        val idCard: String,
        val nickName: String,
        val phonenumber: String,
        val score: Int,
        val sex: String,
        val userId: Int,
        val userName: String
    )
}

data class User(
    val email: String,
    val idCard: String,
    val nickName: String,
    val phonenumber: String,
    val sex: String
)


data class Pass(
    val newPassword: String,
    val oldPassword: String
)


