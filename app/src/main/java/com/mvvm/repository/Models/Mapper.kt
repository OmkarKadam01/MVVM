package com.mvvm.repository.Models

interface Mapper <T,V>{
    fun mapFrom(t:T):V
}