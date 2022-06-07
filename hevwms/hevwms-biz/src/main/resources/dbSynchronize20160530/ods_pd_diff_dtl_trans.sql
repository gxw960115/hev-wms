SELECT
	ROW_ID,
	ORDER_NO,
	PLANT,
	CUSTOMER_MODEL,
	LOCATION,
	MATERIAL_NO,
	MATERIAL_DESP,
	DIFF_TYPE,
	UNIT,
	BARCODE,
	DATE_FORMAT(
		INOUT_DATE,
		'%Y-%m-%d %H:%i:%s'
	) INOUT_DATE,
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
	SUB_LOCATION,
	QTY,
	INVE_SUB_LOCATION,
	PROCESS_FLAG,
	PROCESS_REASON
FROM
	ods_pd_diff_dtl
WHERE
	MODIFY_DATE > DATE_ADD(NOW(), INTERVAL - 30 DAY)
AND PLANT IN (
	SELECT DISTINCT
		cd.`CODE`
	FROM
		cd_factory cd
	WHERE
		cd.country_code = '6600'
)