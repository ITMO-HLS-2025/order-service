package ru.itmo.hls.ordermanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.itmo.hls.ordermanager.entity.Order
import ru.itmo.hls.ordermanager.entity.OrderStatus
import java.time.LocalDateTime

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    @Query("SELECT e FROM Order e join fetch e.tickets WHERE e.status = :status AND e.reservedAt <= :reservedAt")
    fun findAllByStatusAndReservedAtBefore(status: OrderStatus, reservedAt: LocalDateTime) : List<Order>
    fun findOrderById(id: Long): Order?
}
