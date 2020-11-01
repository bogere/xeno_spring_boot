package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author goldsoft25
 *
 */

@Entity
@Table(name = "teachers")
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

     @Column(name = "user_id", nullable = false)
     private long userId;
     
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	*/

    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "contact", nullable = false)
    private String contact;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
   
    //@Temporal(TemporalType.DATE)
    //@Column(name = "joined_date", nullable = false)
    //private Date joinedDate;
    
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
   * Gets address
   *
   * @return the address
   */
  public String getAddress() {
        return address;
    }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
        this.address = address;
    }
  
  
  /**
   * Gets contact
   *
   * @return the contact
   */
  public String getContact() {
        return contact  ;
    }

  /**
   * Sets  contact.
   *
   * @param contact the contact
   */
  public void setContact(String contact) {
        this.contact = contact;
    }
  
  /**
   * Gets gender
   *
   * @return the gender
   */
  public String getGender() {
        return gender  ;
    }

  /**
   * Sets  gender.
   *
   * @param gender the gender
   */
  public void setGender(String gender) {
        this.gender = gender;
    }
  
  
  /**
   * Gets joined_date.
   *
   * @return the joined_date
   */
  //public Date getJoinDate() {
        //return joinedDate;
    //}

  /**
   * Sets joined_date.
   *
   * @param joinedDate the joined_date
   */
  //public void setJoinDate(Date joinedDate) {
        //this.joinedDate = joinedDate;
    //}

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
  
  /*
   *  Dealing with mapping to the User model
   */
  /*public User getUser() {
	  return this.user;
  }
  
  public void setUser(User user) {
	 this.user = user; 
  }
  */
  
  /**
   * Gets userId.
   *
   * @return the userId
   */
  public long getUserId() {
        return id;
    }

  /**
   * Sets userId
   *
   * @param userId the userId
   */
  public void setUserId(long userId) {
        this.userId = userId;
    }
  
  

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ",address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                //", joinedDate='" + joinedDate + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedby='" + updatedBy + '\'' +
                '}';
    }


}
