package com.manamaru.manmaruyoyaku.service

import com.manamaru.manmaruyoyaku.entity.TrnExecCrawlerDate
import com.manamaru.manmaruyoyaku.repository.TrnExecCrawlerDateRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ExecCrawlerDateService(private val trnExecCrawlerDateRepository: TrnExecCrawlerDateRepository){
    fun save(id:Int,date:Date) = trnExecCrawlerDateRepository.save(TrnExecCrawlerDate(id,date))
}