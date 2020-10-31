

package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;


/**
 * @author goldsoft25
 *
 */
@Entity
@Table(name = "students")
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "guardian", nullable = false)
    private String guardian;
    
    @Column(name = "guardian_contact", nullable = false)
    private String guardianContact;

    @Column(name = "admission_number", nullable = false)
    private String admissionNumber;
    
    @Column(name = "class_year", nullable = false)
    private String classYear;
    
    @Column(name = "student_address", nullable = false)
    private String studentAddress;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }

  

  /**
   * Gets guardian.
   *
   * @return the guardian
   */
  public String getGuardian() {
        return guardian;
    }

  /**
   * Sets guardian.
   *
   * @param guardian the last name
   */
  public void setGuardian(String guardian) {
        this.guardian = guardian;
    }
  
  
  /**
   * Gets guardian contact.
   *
   * @return the guardian contact
   */
  public String getGuardianContact() {
        return guardianContact ;
    }

  /**
   * Sets guardian contact.
   *
   * @param guardian contact
   */
  public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }


  /**
   * Gets admissionNumber.
   *
   * @return the admissionNumber
   */
  public String getAdmissionNumber() {
        return admissionNumber;
    }

  /**
   * Sets admissionNumber.
   *
   * @param admissionNumber the admissionNumber
   */
  public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }
  
  /**
   * Gets classYear.
   *
   * @return the classYear
   */
  public String getClassYear() {
        return classYear;
    }

  /**
   * Sets classYear.
   *
   * @param classYear the classYear
   */
  public void setClassYear(String classYear) {
        this.classYear =  classYear;
    }
  
  /**
   * Gets student address.
   *
   * @return the studentAddress
   */
  public String getStudentAddress() {
        return studentAddress;
    }

  /**
   * Sets student address.
   *
   * @param studentAddress the student address
   */
  public void setStudentAddress(String studentAddress) {
        this.studentAddress =  studentAddress;
    }
  
  
  /**
   * Gets registration date.
   *
   * @return the registration date
   */
  public Date getRegistrationDate() {
        return registrationDate;
    }

  /**
   * Sets registration date.
   *
   * @param registrationDate the registration date
   */
  public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

  /**
   * Gets date of birth.
   *
   * @return the date of birth
   */
  public Date getDateOfBirth() {
        return dateOfBirth;
    }

  /**
   * Sets date of birth.
   *
   * @param dateOfBirth the date of birth
   */
  public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
        return createdAt;
    }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

  /**
   * Gets created by.
   *
   * @return the created by
   */
  public String getCreatedBy() {
        return createdBy;
    }

  /**
   * Sets created by.
   *
   * @param createdBy the created by
   */
  public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

  /**
   * Gets updated at.
   *
   * @return the updated at
   */
  public Date getUpdatedAt() {
        return updatedAt;
    }

  /**
   * Sets updated at.
   *
   * @param updatedAt the updated at
   */
  public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

  /**
   * Gets updated by.
   *
   * @return the updated by
   */
  public String getUpdatedBy() {
        return updatedBy;
    }

  /**
   * Sets updated by.
   *
   * @param updatedBy the updated by
   */
  public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", guardian='" + guardian + '\'' +
                 ", guardianContact='" + guardianContact + '\'' +
                ", admissionNumber='" + admissionNumber + '\'' +
                 ", classYear='" + classYear + '\'' +
                  ", dateOfBirth='" + dateOfBirth + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedby='" + updatedBy + '\'' +
                '}';
    }


}
