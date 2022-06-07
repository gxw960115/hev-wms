SELECT
  ROW_ID
, NAME
, CODE
, PARENT_ID
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
, CITY_NAME
, CITY_CODE
, REMARK
, LOCATION_TYPE
, valid_area
, height
, rent_fee
FROM cd_loc_info
	where (MODIFY_DATE > DATE_ADD(NOW(),INTERVAL -150 day)
    OR CREATE_DATE > DATE_ADD(NOW(),INTERVAL -150 day))
	AND PARENT_ID in (
			SELECT DISTINCT w.ROW_ID from cd_wh_info w where w.`code` in (
					SELECT DISTINCT  cd.`code` FROM cd_factory cd where cd.country_code='6600'
)
)


