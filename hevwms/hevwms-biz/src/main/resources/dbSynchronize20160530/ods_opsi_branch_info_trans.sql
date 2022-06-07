SELECT
	ROW_ID,
	LOCATION,
	DIVISION,
	MATERIAL_NO,
	CUSTOMER_MODEL,
	MATERIAL_DESP,
	BASIC_UNIT,
	COLOR,
	DATE_FORMAT(
		PLAN_DATE,
		'%Y-%m-%d %H:%i:%s'
	) PLAN_DATE,
	PLAN_QTY,
	STATUS,
	FLAG,
	CREATE_BY,
	DATE_FORMAT(
		CREATE_DATE,
		'%Y-%m-%d %H:%i:%s'
	) CREATE_DATE,
	MODIFY_BY,
	DATE_FORMAT(
		MODIFY_DATE,
		'%Y-%m-%d %H:%i:%s'
	) MODIFY_DATE,
	FAT_PLAN_DATE,
	SERINO
FROM
	ods_opsi_branch_info
WHERE
	MODIFY_DATE > DATE_ADD(NOW(), INTERVAL - 30 DAY)
AND LOCATION IN (
	SELECT DISTINCT
		loc.`CODE`
	FROM
		cd_loc_info loc
	WHERE
		loc.parent_id IN (
			SELECT DISTINCT
				wh.ROW_ID
			FROM
				cd_wh_info wh
			WHERE
				wh. CODE IN (
					SELECT DISTINCT
						cd.`code`
					FROM
						cd_factory cd
					WHERE
						cd.country_code = '6600'
				)
		)
)