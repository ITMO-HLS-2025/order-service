package ru.itmo.hls.ordermanager.dto

data class TicketDto(
    val id: Long,
    val price: Int,
    val raw: Int,
    val number: Int
)

data class TicketCreateDto(
    val price: Int,
    val raw: Int,
    val number: Int
)
