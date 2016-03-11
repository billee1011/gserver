--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`gg_score` DROP PRIMARY KEY;

DROP TABLE `game`.`gg_score`;

CREATE TABLE `game`.`gg_score` (
	`id` INT NOT NULL,
	`tid` INT,
	`gno` INT,
	`sc_euid` INT,
	`sc_suid` INT,
	`sc_wuid` INT,
	`sc_nuid` INT,
	`createtime` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

