SELECT
  ROW_ID
, NAME
, CODE
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
, FLAG
, VERSION
, REMARK
FROM cd_wh_info

where `CODE` in (SELECT DISTINCT cd.`CODE` from cd_factory cd where cd.country_code ='6600')
