SELECT SEP_TYPE_TECNOMEN SLOT, -- Slot
       SEP_PKT_TECNOMEN PACKID, --Id del pack
       CASE SEP_GSPR_ID
       WHEN 8 THEN SEP_UNITS_IN * TUC_DIVISOR
       ELSE SEP_UNITS_IN  END AS TOTAL,--Total a aprovisionar
       SEP_RENEWAL_PKT RENEWAL--Renovable o no
       FROM SERVICE_PACK_PARAMETERS,
           TECNO_UNITS_CONVERSION
       WHERE SEP_TUC_UNIT_ID = TUC_UNIT_ID(+)
       AND to_date('&fecha','dd/mm/yyyy') BETWEEN SEP_START_DATE AND SEP_END_DATE
       AND SEP_PKT_TECNOMEN='&idPack'