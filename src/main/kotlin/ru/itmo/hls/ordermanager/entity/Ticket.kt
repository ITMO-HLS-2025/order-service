package ru.itmo.hls.ordermanager.entity

import jakarta.persistence.*

@Entity
@Table(name = "ticket")
class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "show_id")
    val showId: Long,

    @Column(name = "seat_id")
    var seatId: Long?,

    @Enumerated(EnumType.STRING)
    var status: TicketStatus,

    @ManyToMany(mappedBy = "tickets")
    var orders: MutableList<Order> = mutableListOf()
)
{
    constructor() : this(0, 0, null, TicketStatus.CANCELLED)
}