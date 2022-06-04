package io.project.Bookingservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DatabaseSequence")
public class DbSequence 
{
	@Transient // ignoring the field ( only work & doesn't save)
	public static final String SEQUENCE_NAME = "reference_Num";
	
	@Id
	private String id;
	private int seq;
	
	public DbSequence() {
		super();
	}

	public DbSequence(int seq) {
		super();
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DatabaseSequence [id=" + id + ", seq=" + seq + "]";
	}
}
