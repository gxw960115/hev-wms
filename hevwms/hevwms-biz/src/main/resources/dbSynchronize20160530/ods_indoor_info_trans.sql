SELECT
	ROW_ID,
	CAR_NO,
	PLAN_NO,
	CX_ID,
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
	FLAG,
	VERSION,
	HAND_FLAG,
	WH_CODE,
	DATE_FORMAT(
		IN_DATE,
		'%Y-%m-%d %H:%i:%s'
	) IN_DATE,
	REG_NO,
	REMARK,
	DATE_FORMAT(
		OUT_DATE,
		'%Y-%m-%d %H:%i:%s'
	) OUT_DATE
FROM
	ods_indoor_info
WHERE
	MODIFY_DATE > DATE_ADD(NOW(), INTERVAL - 30 DAY)
AND WH_CODE IN (
	SELECT
		cd.`code`
	FROM
		cd_factory cd
	WHERE
		cd.country_code = '6600'
)