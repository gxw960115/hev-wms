SELECT
	ROW_ID,
	PLANT,
	CUSTOMER_MODEL,
	LOCATION,
	MATERIAL_NO,
	MATERIAL_DESP,
	UNIT,
	BARCODE,
	ORDER_NO,
	ORDER_ITEM,
	DOC_TPYE,
	SAP_ORDER_NO,
	SAP_ORDER_ITEM,
	TOTAL_STOCK_DAYS,
	CURRENT_STOCK_DAYS,
	BATCH_NO,
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
	QTY,
	USE_QTY,
	PALLET,
	SUB_LOCATION,
	SUB_LOCATION_FLAG,
	BATCH_TIME,
	INVENTORY_DATE,
	DATE_FORMAT(
		FIRST_IN_DATE,
		'%Y-%m-%d %H:%i:%s'
	) FIRST_IN_DATE
FROM
	ods_inventory_info_dtl_history
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