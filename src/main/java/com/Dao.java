package com;

import java.io.IOException;

public interface Dao
{
    void insert() throws IOException;
    void retrieveDoctors();
    void retrievePatients();
    void update() throws IOException;

    void updateFeedback() throws IOException;
    void deleteDoctor() throws IOException;
    void deletePatient() throws IOException;
    void specialisation() throws IOException;
    void patientData() throws IOException;
}
