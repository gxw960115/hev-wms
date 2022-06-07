SELECT
  inb.ROW_ID
, inb.PO_NO
, inb.PO_ITEM_NO
, inb.INBOUND_DELIVERY_NO
, inb.IND_CREATE_DATE
, inb.IND_LAST_MODIFY_DATE
, inb.INBOUND_ITEM_NO
, inb.MATERIAL_NO
, inb.CUSTOMER_MODEL
, inb.MATERIAL_DESP
, inb.QTY
, inb.INBOUND_LOCATION
, inb.VERSION
, inb.FINISH_QTY
, inb.UNIT
, inb.DELIVER_DATE
, inb.INBOUND_CLOSE
, inb.FINISH_FLAG
, inb.CREATE_BY
, DATE_FORMAT(
		inb.CREATE_DATE,
		'%Y-%m-%d %H:%i:%s'
	) CREATE_DATE
, DATE_FORMAT(
		inb.MODIFY_DATE,
		'%Y-%m-%d %H:%i:%s'
	) MODIFY_DATE
, inb.FLAG
FROM stg_inbound_down inb,cd_factory fac,cd_wh_info wh, cd_loc_info loc
where inb.INBOUND_LOCATION=loc.`CODE` and loc.PARENT_ID=wh.ROW_ID and wh.`CODE`=fac.`CODE`
and fac.COUNTRY_CODE='6600' and inb.MODIFY_DATE>DATE_ADD(NOW(),INTERVAL -30 DAY)