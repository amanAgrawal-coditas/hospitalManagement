package com;

import javax.persistence.*;
import java.util.List;

@Entity
public class PatientPojo {
    @Id
    private int patient_id;
    private String patient_name;
    private int patient_age;
    private String disease;
    private String feedback;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<DoctorPojo> doctorPojos;

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public List<DoctorPojo> getDoctorPojos() {
        return doctorPojos;
    }

    public void setDoctorPojos(List<DoctorPojo> doctorPojos) {
        this.doctorPojos = doctorPojos;
    }

    @Override
    public String toString() {
        return "PatientPojo{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_age=" + patient_age +
                ", disease='" + disease + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}


