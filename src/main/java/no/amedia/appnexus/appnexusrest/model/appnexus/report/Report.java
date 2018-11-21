package no.amedia.appnexus.appnexusrest.model.appnexus.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {
        "hour", "seller_member_name", "buyer_member_name", "advertiser_name",
        "publisher_name", "imps", "imps_viewed", "view_measured_imps", "imps_viewed",
        "view_rate", "clicks", "total_convs", "ctr", "convs_rate",
          "placement_id", "placement_name", "creative_id", "creative_name"})
@JsonRootName("report")
public class Report {
    @JsonProperty
    String hour;
    @JsonProperty("seller_member_name")
    String sellerMemberName;
    @JsonProperty("buyer_member_name")
    String buyerMemberName;
    @JsonProperty("advertiser_name")
    String advertiserName;
    @JsonProperty("publisher_name")
    String publisherName;
    @JsonProperty
    String imps;
    @JsonProperty("view_measured_imps")
    int viewMeasuredImps;
    @JsonProperty("imps_viewed")
    int impsViewed;
    @JsonProperty("view_rate")
    String viewRate;
    @JsonProperty
    String clicks;
    @JsonProperty
    String totalConvs;
    @JsonProperty
    String ctr;
    @JsonProperty
    String convsRate;
    @JsonProperty("placement_id")
    String placementId;
    @JsonProperty("placement_name")
    String placementName;
    @JsonProperty("creative_id")
    String creativeId;
    @JsonProperty("creative_name")
    String creativeName;
}

