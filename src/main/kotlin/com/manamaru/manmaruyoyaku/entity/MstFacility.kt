package com.manamaru.manmaruyoyaku.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "mst_facility")
data class MstFacility(
                @Id @GeneratedValue var facilityId: Int = 0,
                @Column(name="facility_name", nullable = false) var facilityName: String = "",
                @Column(name="facility_area_name",nullable = false) var facilityAreaName: String = "",
                @Column(name="facility_display_name",nullable = false) var facilityDisplayName: String = "") {
}