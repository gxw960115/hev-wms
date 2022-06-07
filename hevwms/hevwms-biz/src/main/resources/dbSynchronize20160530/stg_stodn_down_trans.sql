SELECT
  ROW_ID
, STO_NO
, STO_ITEM_NO
, STODN_NO
, STODN_ITEM_NO
, QTY
, MATERIAL_NO
, UNIT
, LOCATION
, MESSAGE
, GI_FINISH_QTY
, GI_FINISH_FLAG
, GI_FLAG
, GR_FINISH_QTY
, GR_FINISH_FLAG
, GR_FLAG
, GI_SAP_FLAG
, GR_SAP_FLAG
, GI_SAP_MSG
, GI_DOC
, GR_SAP_MSG
, GR_DOC
, REMARK
, FLAG
, CREATE_BY
, DATE_FORMAT(
		CREATE_DATE,
		'%Y-%m-%d %H:%i:%s'
	) CREATE_DATE
, MODIFY_BY
, DATE_FORMAT(
		MODIFY_DATE,
		'%Y-%m-%d %H:%i:%s'
	) MODIFY_DATE
, SAP_FLAG
, PRESCAN_FLAG
, PLANT
, gi_date
, gr_date
FROM stg_stodn_down
where  MODIFY_DATE>DATE_ADD(NOW(),INTERVAL -30 DAY) AND PLANT in (select cd.`code` from cd_factory cd where cd.country_code='6600')

