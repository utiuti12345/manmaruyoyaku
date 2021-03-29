package com.manamaru.manmaruyoyaku.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "trn_exec_crawler_date")
data class TrnExecCrawlerDate(
        @Id var execCrawlerDateId: Int = 0,
        @Column(name="exec_crawler_date", nullable = false) var execCrawlerDate: Date = Date()) {
}