package ru.itmo.hls.ordermanager.service

import org.springframework.stereotype.Service
import ru.itmo.hls.ordermanager.entity.Ticket
import ru.itmo.hls.ordermanager.entity.TicketStatus
import ru.itmo.hls.ordermanager.repository.TicketRepository


@Service
class TicketService(
    private val ticketRepository: TicketRepository
)  {

    fun findAllBySeatIdInAndShowId(seatIds: List<Long>, showId: Long, status: TicketStatus): List<Ticket> {
        return ticketRepository.findAllBySeatIdInAndShowId(seatIds, showId, status)
    }

    fun findAllByOrder(orderId: Long): List<Ticket> {
        return ticketRepository.findAllByOrder(orderId)
    }
//
//    fun findTicketsByOrderId(orderId: Long, pageable: Pageable): Page<TicketProjection> {
//        return ticketRepository.findTicketsByOrderId(orderId, pageable)
//    }

    fun save(ticket: Ticket): Ticket {
        return ticketRepository.save(ticket)
    }
}