package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication
{

    public static void main(String[] args) throws IOException {
        DaoImpl dao=new DaoImpl();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to insert patient and doctors");
            System.out.println("Press 2 to retrieve doctors");
            System.out.println("Press 3 to retrieve patients");
            System.out.println("Press 4 to update doctor's fees");
            System.out.println("Press 5 to update patient's feedback");
            System.out.println("Press 6 to delete patient ");
            System.out.println("Press 7 to delete doctor");
            System.out.println("Press 8 for specialisation of doctor");
            System.out.println("Press 9 for the patient data as per feedback");
            int choice=Integer.parseInt(bufferedReader.readLine());
            switch (choice)
            {
                case 0:
                {
                    System.exit(0);
                }
                case 1:
                {
                    dao.insert();
                    break;
                }
                case 2:
                {
                    dao.retrieveDoctors();
                    break;
                }
                case 3:
                {
                    dao.retrievePatients();
                    break;
                }
                case 4:
                {
                    dao.update();
                    break;
                }
                case 5:
                {
                    dao.updateFeedback();
                    break;
                }
                case 6:
                {
                    dao.deletePatient();
                    break;
                }
                case 7:
                {
                    dao.deleteDoctor();
                    break;
                }
                case 8:
                {
                    dao.specialisation();
                    break;
                }
                case 9:
                {
                    dao.patientData();
                }
                default:
                {
                    System.out.println("Enter a valid choice");
                }
            }
        }

    }
}
