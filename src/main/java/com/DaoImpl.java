package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao
{
    static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("aman");
    static EntityManager entityManager=entityManagerFactory.createEntityManager();
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

    public void insert() throws IOException
    {
        entityManager.getTransaction().begin();
        PatientPojo patientPojo=new PatientPojo();
        System.out.println("Enter patient id");
        patientPojo.setPatient_id(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Enter patient name");
        patientPojo.setPatient_name(bufferedReader.readLine());
        System.out.println("Enter patient age");
        patientPojo.setPatient_age(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Enter patient's disease");
        patientPojo.setDisease(bufferedReader.readLine());
        System.out.println("Enter Patient's feed back");
        patientPojo.setFeedback(bufferedReader.readLine());
        List<PatientPojo> patientPojoList=new ArrayList<PatientPojo>();
        patientPojoList.add(patientPojo);
        DoctorPojo doctorPojo=new DoctorPojo();
        System.out.println("Enter doctor's id");
        doctorPojo.setDoctor_id(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Enter doctor's name");
        doctorPojo.setDoctor_name(bufferedReader.readLine());
        System.out.println("Enter experience");
        doctorPojo.setExperience(Float.parseFloat(bufferedReader.readLine()));
        System.out.println("Enter specialisation");
        doctorPojo.setSpecialisation(bufferedReader.readLine());
        System.out.println("Enter doctor's fees");
        doctorPojo.setFees(Integer.parseInt(bufferedReader.readLine()));
        List<DoctorPojo>doctorPojoList=new ArrayList<DoctorPojo>();
        doctorPojoList.add(doctorPojo);

        doctorPojo.setPatientPojos(patientPojoList);
        patientPojo.setDoctorPojos(doctorPojoList);
        entityManager.persist(doctorPojo);
        entityManager.persist(patientPojo);
        entityManager.getTransaction().commit();
    }
    public void retrieveDoctors()
    {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<DoctorPojo> from=criteriaQuery.from(DoctorPojo.class);
        CriteriaQuery<Object> select=criteriaQuery.select(from);
        TypedQuery<Object> typedQuery=entityManager.createQuery(select);
        List<Object> list=typedQuery.getResultList();
        list.stream().forEach(System.out::println);
    }
    public void retrievePatients()
    {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<PatientPojo> from=criteriaQuery.from(PatientPojo.class);
        CriteriaQuery<Object> select=criteriaQuery.select(from);
        TypedQuery<Object> typedQuery=entityManager.createQuery(select);
        List<Object> list=typedQuery.getResultList();
        list.stream().forEach(System.out::println);
    }
    public void update() throws IOException
    {
        entityManager.getTransaction().begin();
        System.out.println("Enter the doctor id you want to update");
        int id=Integer.parseInt(bufferedReader.readLine());
        DoctorPojo doctorPojo= entityManager.find(DoctorPojo.class,id);
        System.out.println("Enter the updated fees of the doctor");
        int fees=Integer.parseInt(bufferedReader.readLine());
        doctorPojo.setFees(fees);
        entityManager.getTransaction().commit();
        System.out.println("The fees has been updated");

    }
    public void updateFeedback() throws IOException
    {
        entityManager.getTransaction().begin();
        System.out.println("Enter the patient id you want to change the feedback for");
        int id=Integer.parseInt(bufferedReader.readLine());
        PatientPojo patientPojo=entityManager.find(PatientPojo.class,id);
        System.out.println("Enter the new feeback you want to give");
        String feedback=bufferedReader.readLine();
        patientPojo.setFeedback(feedback);
        entityManager.getTransaction().commit();
        System.out.println("The feedback has been changed");

    }
    public void deleteDoctor() throws IOException {
        entityManager.getTransaction().begin();
        System.out.println("Enter the id you want to delete");
        int id=Integer.parseInt(bufferedReader.readLine());
        DoctorPojo doctorPojo= entityManager.find(DoctorPojo.class,id);
        entityManager.remove(doctorPojo);
        entityManager.getTransaction().commit();
        System.out.println("The doctor record is deleted");

    }
    public void deletePatient() throws IOException
    {
        entityManager.getTransaction().begin();
        System.out.println("Enter the patient id you want to delete");
        int id=Integer.parseInt(bufferedReader.readLine());
        PatientPojo patientPojo=entityManager.find(PatientPojo.class,id);
        entityManager.remove(patientPojo);
        entityManager.getTransaction().commit();
        System.out.println("The patient has been discharged");
    }
 public void specialisation() throws IOException
 {
     System.out.println("enter the specialisation");
     String specialisation=bufferedReader.readLine();
     CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
     CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
     Root<DoctorPojo> from=criteriaQuery.from(DoctorPojo.class);
     CriteriaQuery<Object> select=criteriaQuery.select(from);
     select.where(criteriaBuilder.equal(from.get("specialisation"),specialisation));
     TypedQuery<Object> typedQuery=entityManager.createQuery(select);
     List<Object> list=typedQuery.getResultList();
     list.stream().forEach(System.out::println);
 }
    public void patientData() throws IOException
    {
        System.out.println("enter the feedback");
        String feedback=bufferedReader.readLine();
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<PatientPojo> from=criteriaQuery.from(PatientPojo.class);
        CriteriaQuery<Object> select=criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get("feedback"),feedback));
        TypedQuery<Object> typedQuery=entityManager.createQuery(select);
        List<Object> list=typedQuery.getResultList();
        list.stream().forEach(System.out::println);
    }



}
