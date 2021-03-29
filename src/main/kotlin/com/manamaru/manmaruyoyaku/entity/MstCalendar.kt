package com.manamaru.manmaruyoyaku.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "mst_calendar")
data class MstCalendar(
        @Id @GeneratedValue var calendarId: Int = 0,
        @Column(name="date", nullable = false) var date: Date = Date(),
        @Column(name="name",nullable = false) var name: String = "") {
}