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

DROP TABLE IF EXISTS `mst_calendar`;
CREATE TABLE `manmaru`.`mst_calendar` (
  `calendar_id` INT(7) NOT NULL,
  `date` DATE NOT NULL,
  `name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`calendar_id`)
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

DROP TABLE IF EXISTS `trn_exec_crawler_date`;
CREATE TABLE `manmaru`.`trn_exec_crawler_date` (
  `exec_crawler_date_id` INT(7) NOT NULL,
  `exec_crawler_date` DATE NOT NULL,
  PRIMARY KEY (`exec_crawler_date_id`)
);
