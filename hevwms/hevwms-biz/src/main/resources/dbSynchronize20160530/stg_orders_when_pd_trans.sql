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
, qty
, finish_qty
, finish_flag
, create_by
, DATE_FORMAT(
		create_date,
		'%Y-%m-%d %H:%i:%s'
	) create_date
, modify_by
, DATE_FORMAT(
		modify_date,
		'%Y-%m-%d %H:%i:%s'
	) modify_date
, in_out_flag
, iogp_flag
FROM stg_orders_when_pd
where plant in (select fac.code from cd_factory fac where fac.country_code='6600')
and MODIFY_DATE >DATE_ADD(NOW(),INTERVAL -30 DAY)