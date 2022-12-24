package com.example.listaheroescompose.model

import androidx.annotation.DrawableRes

/****
 * Project: ListaHeroesCompose
 * From: com.example.listaheroescompose.model
 * Created by: Victor Sanjines Lopez on 12/12/2022 at 19:28
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
data class Superhero(
    var name: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
