package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;

import java.util.List;

public interface DoctorDao extends Dao<DoctorEntity, Long>
{

    /**
     * Finds doctors by theirs specialization
     * @param specialization
     * @return
     */
    List<DoctorEntity> findBySpecialization(Specialization specialization);

    /**
     * Count number of visits of particular patient and doctors
     * @param docFirstName
     * @param docLastName
     * @param pateientFirstName
     * @param patientLastName
     * @return
     */
    long countNumOfVisitsWithPatient(String docFirstName, String docLastName, String pateientFirstName, String patientLastName);


}
