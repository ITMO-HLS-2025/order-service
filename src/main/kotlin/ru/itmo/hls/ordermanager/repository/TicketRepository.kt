package ru.itmo.hls.ordermanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.itmo.hls.ordermanager.entity.Ticket
import ru.itmo.hls.ordermanager.entity.TicketStatus


@Repository
interface TicketRepository : JpaRepository<Ticket, Long> {
    @Query(
        """from Ticket t 
                where t.showId = :showId
                and t.seatId in :seatIds
        and t.status <> 'CANCELLED'"""
    )
    fun findAllBySeatIdInAndShowId(
        seatIds: Collection<Long>,
        showId: Long,
        canceledStatus: TicketStatus
    ): List<Ticket>

    @Query("from Ticket t  join t.orders o where o.id = :orderId")
    fun findAllByOrder(orderId : Long): List<Ticket>

//    @Query(
//        """
//        select t.id AS id,
//               sp.price AS price,
//               s.rowNumber AS rowNumber,
//               s.seatNumber AS seatNumber
//        from Ticket t
//        join t.seat s
//        join SeatPrice sp ON sp.seat.id = s.id AND sp.show.id = t.show.id
//        join t.orders o
//        where o.id = :orderId
//    """
//    )
//    fun findTicketsByOrderId(
//        orderId: Long,
//        pageable: Pageable
//    ): Page<TicketProjection>;
}