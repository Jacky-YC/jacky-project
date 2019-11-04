package com.fastone.test.domain;

import com.fastone.test.listener.EntityListener;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@EntityListeners(EntityListener.class)
@MappedSuperclass
public abstract class BaseDomain implements Serializable {

	private static final long serialVersionUID = 5591803565672838676L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreatedBy
	private Long createBy;

	@LastModifiedBy
	private Long updateBy;

	@CreatedDate
	private Date createAt;

	@LastModifiedDate
	private Date updateAt;

	private Boolean deleted = false;


}
