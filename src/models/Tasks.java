package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllTasks",
            query = "SELECT m FROM Tasks AS m ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name = "getNowTasks",
            query = "SELECT m FROM Tasks AS m WHERE m.finish_flag = 0 ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name = "getNowTasksCount",
            query = "SELECT COUNT(m) FROM Tasks AS m WHERE m.finish_flag = 0"
            ),

    @NamedQuery(
            name = "getFinishTasks",
            query = "SELECT m FROM Tasks AS m WHERE m.finish_flag = 1 ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name = "getFinishTasksCount",
            query = "SELECT COUNT(m) FROM Tasks AS m WHERE m.finish_flag = 1"
            )
})


@Table(name="tasks")
public class Tasks{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="title",length=255,nullable=false)
	private String title;

	@Column(name="content",length=255,nullable=false)
	private String content;

	@Column(name="content_2",length=255)
	private String content_2;

	@Column(name="finishdate")
	private String finishdate;

	@Column(name="startdate")
	private String startdate;

	@Column(name="finish_flag",nullable=false)
	private Integer finish_flag;

	@Column(name="priority",length=5,nullable=false)
	private String priority;



	@Column(name="created_at",nullable=false)
	private Timestamp created_at;

	@Column(name="updated_at",nullable=false)
	private Timestamp updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent_2() {
		return content_2;
	}

	public void setContent_2(String content_2) {
		this.content_2 = content_2;
	}


	public String getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getFinish_flag() {
		return finish_flag;
	}

	public void setFinish_flag(Integer finish_flag) {
		this.finish_flag = finish_flag;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}



}