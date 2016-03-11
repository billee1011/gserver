--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`gg_hist` DROP PRIMARY KEY;

DROP TABLE `game`.`gg_hist`;

CREATE TABLE `game`.`gg_hist` (
	`id` INT NOT NULL,
	`tid` INT,
	`gno` INT,
	`d_euid` VARCHAR(40),
	`d_suid` VARCHAR(40),
	`d_wuid` VARCHAR(40),
	`d_nuid` VARCHAR(40),
	`d_in` VARCHAR(2),
	`d_out` VARCHAR(2),
	`type` INT,
	`step` INT,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

