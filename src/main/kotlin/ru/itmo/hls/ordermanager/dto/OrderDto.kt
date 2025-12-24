package ru.itmo.hls.ordermanager.dto

import ru.itmo.hls.ordermanager.entity.OrderStatus
import java.time.LocalDateTime


data class OrderDto (
    val id: Long,
    val createdAt: LocalDateTime,
    val reservedAt: LocalDateTime?,
    val status: OrderStatus = OrderStatus.RESERVED,
    val seat : List<SeatDto>,
    val price: Int
    )

data class OrderPayload(
    val seatIds : List<Long>,
    val showId : Long
)