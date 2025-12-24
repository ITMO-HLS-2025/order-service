package ru.itmo.hls.ordermanager.mapper

import ru.itmo.tickets_shop.entity.SeatPrice
import ru.itmo.tickets_shop.entity.Ticket
import ru.itmo.tickets_shop.entity.TicketStatus

fun SeatPrice.toEntity(): Ticket = Ticket(
    show = show,
    seat = seat,
    status = TicketStatus.RESERVED
)
