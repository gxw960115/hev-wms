SELECT
	row_id,
	USER_ID,
	LOC_ID,
	USER_TYPE,
	LOC_CODE,
	WH_ID,
	COUNTRY_CODE
FROM
	cd_user_wh_loc
WHERE
	COUNTRY_CODE = '6600'