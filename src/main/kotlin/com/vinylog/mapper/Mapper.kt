package com.vinylog.mapper

interface Mapper<V, U> {

    fun map(v: V): U
}