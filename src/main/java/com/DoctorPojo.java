package com;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class DoctorPojo
{
    @Id
    private int doctor_id;
    private String doctor_name;
    private float experience;
    private String specialisation;
    private int fees;
    @ManyToMany(cascade = CascadeType.ALL)
    private List <PatientPojo> patientPojos;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public List<PatientPojo> getPatientPojos() {
        return patientPojos;
    }

    public void setPatientPojos(List<PatientPojo> patientPojos)
    {
        this.patientPojos = patientPojos;
    }

    @Override
    public String toString()
    {
        return "DoctorPojo{" +
                "doctor_id=" + doctor_id +
                ", doctor_name='" + doctor_name + '\'' +
                ", experience=" + experience +
                ", specialisation='" + specialisation + '\'' +
                ", fees=" + fees +
                ", patientPojos=" + patientPojos +
                '}';
    }
}
