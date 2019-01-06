package com.example.faisal.diceroller.roomviewmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word : String)




































/*
apply plugin: 'kotlin-kapt'


kotlin {
    experimental {
        coroutines "enable"
    }
}

// Room components
implementation "android.arch.persistence.room:runtime:$rootProject.roomVersion"
kapt "android.arch.persistence.room:compiler:$rootProject.roomVersion"
androidTestImplementation "android.arch.persistence.room:testing:$rootProject.roomVersion"

// Lifecycle components
implementation "android.arch.lifecycle:extensions:$rootProject.archLifecycleVersion"
kapt "android.arch.lifecycle:compiler:$rootProject.archLifecycleVersion"

// Coroutines
api "org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutines"
api "org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutines"

*/
