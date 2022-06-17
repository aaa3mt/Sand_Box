package com.example.sandbox.domain

abstract class Mapper<in FROM, out TO> {
    abstract fun map(from: FROM): TO
}