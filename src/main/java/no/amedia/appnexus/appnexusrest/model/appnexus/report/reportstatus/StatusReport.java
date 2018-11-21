package no.amedia.appnexus.appnexusrest.model.appnexus.report.reportstatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusReport {
    @JsonProperty("created_on")
    String createdOn;
    @JsonProperty("cache_hit")
    String cacheHit;
    @JsonProperty("fact_cache_hit")
    String factCacheHit;
    @JsonProperty("json_request")
    String jsonRequest;
    @JsonProperty("header_info")
    String headerInfo;
    @JsonProperty("report_size")
    String reportSize;
    @JsonProperty("row_count")
    String rowCount;
    String url;
}
/*"name": null,
            "created_on": "2017-03-13 18:15:48",
            "cache_hit": false,
            "fact_cache_hit": false,
            "json_request": "{\"report\":{\"report_type\":\"network_analytics\",\"report_interval\":
                \"last_48_hours\",\"columns\":[\"day\",\"imps\",\"clicks\"],\"filters\":[{\"geo_country\":
                \"US\"},{\"entity_member_id\":\"514\"},{\"entity_member_id\":null}],\"orders\":
                [{\"order_by\":\"day\",\"direction\":\"ASC\"},{\"order_by\":\"imps\",\"direction\":
                \"DESC\"}]}}",
            "header_info": "Report type:,network_analytics\r\n,\r\nRun at:,2017-03-13 18:15:48\r\nStart date:,
                \r\nEnd date:,\r\nTimezone:,\r\nUser:,John Smith (9385)\r\n",
            "report_size": "10",
            "row_count": "35",
            "url": "report-download?id=ca9955709eade9a0e89f5cda5345c12r"*/
