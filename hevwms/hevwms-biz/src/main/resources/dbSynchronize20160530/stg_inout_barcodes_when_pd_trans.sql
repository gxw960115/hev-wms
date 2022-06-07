SELECT
  id
, order_no
, order_item
, order_type
, doc_tpye
, material_no
, unit
, plant
, location
, barcode
, scan_qty
, in_out_flag
, DATE_FORMAT(
		create_time,
		'%Y-%m-%d %H:%i:%s'
	) create_time
FROM stg_inout_barcodes_when_pd
where plant in (select fac.code from cd_factory fac where fac.country_code='6600')
and create_time >DATE_ADD(NOW(),INTERVAL -30 DAY)