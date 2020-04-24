package com.charters.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue
    	private Integer id;
	@Column
	private Integer amount;
	@Column
	private Integer customerId;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private LocalDate transactionDate;
	@Column
	private Integer rewards;
}
