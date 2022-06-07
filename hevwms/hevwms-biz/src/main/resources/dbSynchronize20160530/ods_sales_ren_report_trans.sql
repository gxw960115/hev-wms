SELECT
	ROW_ID,
	DN_NO,
	MATERIAL_NO,
	CUSTOMER_MODEL,
	MATERIAL_DESP,
	LOCATION,
	BARCODE,
	RESP_DEPT,
	GOODS_CLASS,
	CRM_NO,
	REASON,
	CREATE_BY,
	DATE_FORMAT(
		CREATE_DATE,
		'%Y-%m-%d %H:%i:%s'
	) CREATE_DATE
FROM
	ods_sales_ren_report
WHERE
	CREATE_DATE > DATE_ADD(NOW(), INTERVAL - 30 DAY)
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
						cd.`CODE`
					FROM
						cd_factory cd
					WHERE
						cd.country_code = '6600'
				)
		)
)