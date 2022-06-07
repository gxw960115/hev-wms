SELECT
  ROW_ID
, LOCATION
, SAP_DOWN_DATE
, MATERIAL_NO
, MATERIAL_DESP
, QTY
, UNIT
, BATCH_NO
, DATE_FORMAT(
		CREATE_DATE,
		'%Y-%m-%d %H:%i:%s'
	) CREATE_DATE
, DATE_FORMAT(
		MODIFY_DATE,
		'%Y-%m-%d %H:%i:%s'
	) MODIFY_DATE
, VERSION
, PLANT
, CUSTOMER_MODEL
, FLAG
FROM stg_sap_stock
where PLANT in (select fac.code from cd_factory fac where fac.country_code='6600')
 and MODIFY_DATE >DATE_ADD(NOW(),INTERVAL -30 DAY)