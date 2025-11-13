package pe.unmsm.crm.marketing.leads.domain.vo;

import lombok.Value;

@Value
public class TrackingUTM {
    String source;
    String medium;
    String campaign;
    String term;
    String content;

    public TrackingUTM(String source, String medium, String campaign) {
        this.source = source;
        this.medium = medium;
        this.campaign = campaign;
        this.term = null;
        this.content = null;
    }
    
    public TrackingUTM(String source, String medium, String campaign, String term, String content) {
        this.source = source;
        this.medium = medium;
        this.campaign = campaign;
        this.term = term;
        this.content = content;
    }
}