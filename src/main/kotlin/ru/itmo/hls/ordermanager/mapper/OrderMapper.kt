package ru.itmo.hls.ordermanager.mapper

import ru.itmo.tickets_shop.dto.OrderDto
import ru.itmo.tickets_shop.dto.OrderPayload
import ru.itmo.tickets_shop.entity.Order
import ru.itmo.tickets_shop.entity.Ticket
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.collections.map


fun OrderPayload.toEntity(tickets: MutableList<Ticket>, price : Int): Order =
    Order(
        id = 0,
        createdAt = LocalDateTime.now(),
        reservedAt = LocalDateTime.now().plus(90, ChronoUnit.MINUTES),
        tickets = tickets,
        sumPrice = price
    )

fun Order.toDto() : OrderDto =
    OrderDto(
        id = id,
        reservedAt = reservedAt,
        status = status,
        seat = tickets.map { it.seat }.map { it!!.toSeatDto() },
        price = sumPrice,
        createdAt = createdAt
    )