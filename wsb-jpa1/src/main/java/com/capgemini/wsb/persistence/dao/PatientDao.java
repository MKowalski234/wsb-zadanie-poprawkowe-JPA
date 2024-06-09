package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.util.Collection;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{

    /**
     * Finds list of patients having visits with given doctor
     * @param firstName
     * @param lastName
     * @return
     */
    List<PatientEntity> findByDoctor(String firstName, String lastName);

    /**
     * Finds patient having visits of type TreatmentType
     * @param treatmentType
     * @return
     */
    List<PatientEntity> findPatientsHavingTreatmentType(TreatmentType treatmentType);

    /**
     * Finds patients having the same location (address) as given doctor
     * @param firstName doctor first name
     * @param lastName doctor last name
     * @return
     */
    List<PatientEntity> findPatientsSharingSameLocationWithDoc(String firstName, String lastName);

    /**
     * Finds homeless patients
     * @return
     */
    List<PatientEntity> findPatientsWithoutLocation();


}
