package com.manamaru.manmaruyoyaku.domain

class Facility {
    val facilityId:Int
    val facilityName:String
    val facilityAreaName:String
    val facilityDisplayName:String
    constructor(facilityId:Int,facilityName:String,facilityAreaName:String,facilityDisplayName:String){
        this.facilityId = facilityId
        this.facilityName = facilityName
        this.facilityAreaName = facilityAreaName
        this.facilityDisplayName = facilityDisplayName
    }
}