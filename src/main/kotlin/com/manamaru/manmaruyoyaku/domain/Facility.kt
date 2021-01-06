package com.manamaru.manmaruyoyaku.domain

class Facility {
    val facilityId:Int
    val facilityName:String
    val facilityAreaName:String
    val facilityDisplayName:String
    constructor(_facilityId:Int,_facilityName:String,_facilityAreaName:String,_facilityDisplayName:String){
        this.facilityId = _facilityId
        this.facilityName = _facilityName
        this.facilityAreaName = _facilityAreaName
        this.facilityDisplayName = _facilityDisplayName
    }
}