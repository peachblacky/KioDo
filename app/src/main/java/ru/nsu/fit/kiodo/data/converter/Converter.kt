package ru.nsu.fit.kiodo.data.converter

interface Converter<I, O> {

    fun convertToO(from: I): O

    fun convertToI(from: O): I

}