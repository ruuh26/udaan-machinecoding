package com.example.model;

import java.util.List;

public class SelfAssessment {

    List<String> symptoms;
    int userId;
    boolean travelHistory;
    boolean contactWithCovidPt;

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(boolean travelHistory) {
        this.travelHistory = travelHistory;
    }

    public boolean isContactWithCovidPt() {
        return contactWithCovidPt;
    }

    public void setContactWithCovidPt(boolean contactWithCovidPt) {
        this.contactWithCovidPt = contactWithCovidPt;
    }

}
