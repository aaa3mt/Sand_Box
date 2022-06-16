package com.example.sandbox.di

abstract class Mapper<in FROM, out TO> {
    abstract fun map(from: FROM): TO
}