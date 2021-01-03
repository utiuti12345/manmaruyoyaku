DROP SCHEMA IF EXISTS manmaru;
CREATE SCHEMA manmaru;
USE manmaru;
SET AUTOCOMMIT=0;

DROP TABLE IF EXISTS `mst_facility`;
CREATE TABLE `manmaru`.`mst_facility` (
  `facility_id` INT(7) NOT NULL,
  `facility_name` VARCHAR(25) NOT NULL,
  `facility_area_name` VARCHAR(25) NOT NULL,
  `facility_display_name` VARCHAR(50) NULL,
  PRIMARY KEY (`facility_id`)
);

DROP TABLE IF EXISTS `trn_facility_schedule`;
CREATE TABLE `manmaru`.`trn_facility_schedule` (
  `facility_id` INT(7) NOT NULL,
  `schedule_date` DATE NOT NULL,
  `schedule_start_time` VARCHAR(25) NOT NULL,
  `schedule_end_time` VARCHAR(25) NOT NULL,
  `schedule_is_available` BOOLEAN NULL,
  PRIMARY KEY (`facility_id`,`schedule_date`,`schedule_start_time`,`schedule_end_time`)
);