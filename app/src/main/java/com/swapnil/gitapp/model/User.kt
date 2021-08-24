package com.swapnil.gitapp.model

data class User(
    val avatar_url: String,
    val bio: String,
    val blog: String,
    val company: String,
    val created_at: String,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val updated_at: String,
    val url: String
) {
    override fun toString(): String {
        return "User(avatar_url='$avatar_url', bio='$bio', blog='$blog', company='$company', created_at='$created_at', events_url='$events_url', followers=$followers, followers_url='$followers_url', following=$following, following_url='$following_url', gists_url='$gists_url', gravatar_id='$gravatar_id', html_url='$html_url', id=$id, location='$location', login='$login', name='$name', node_id='$node_id', organizations_url='$organizations_url', public_gists=$public_gists, public_repos=$public_repos, received_events_url='$received_events_url', repos_url='$repos_url', site_admin=$site_admin, starred_url='$starred_url', subscriptions_url='$subscriptions_url', type='$type', updated_at='$updated_at', url='$url')"
    }
}