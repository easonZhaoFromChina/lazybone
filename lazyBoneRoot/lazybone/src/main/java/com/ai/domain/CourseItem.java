package com.ai.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by eason on 2017/2/16.
 */
@Entity
@Table(name="course_item")
public class CourseItem {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "course_item_id",unique = true,nullable = false)
    private String courseItemId;
    @Column(name = "item_name")
    private String itemName;
    @ManyToOne
    @JoinColumn(name = "exercise_type")
    private FitAction exerciseType;
    @Column(name = "exercise_unit")
    private String exerciseUnit;
    @Column(name = "require_times")
    private int requireTimes;
    private String imageUrl;
    @Column(name = "create_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "update_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("courseItems")
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseItem that = (CourseItem) o;

        return courseItemId.equals(that.courseItemId);

    }

    @Override
    public int hashCode() {
        return courseItemId.hashCode();
    }


    public CourseItem() {
    }

    public CourseItem(String itemName, FitAction exerciseType, String exerciseUnit, int requireTimes, String imageUrl, Date createDate, Date updateDate, Course course) {
        this.itemName = itemName;
        this.exerciseType = exerciseType;
        this.exerciseUnit = exerciseUnit;
        this.requireTimes = requireTimes;
        this.imageUrl = imageUrl;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.course = course;
    }

    public String getCourseItemId() {
        return courseItemId;
    }

    public void setCourseItemId(String courseItemId) {
        this.courseItemId = courseItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public FitAction getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(FitAction exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getExerciseUnit() {
        return exerciseUnit;
    }

    public void setExerciseUnit(String exerciseUnit) {
        this.exerciseUnit = exerciseUnit;
    }

    public int getRequireTimes() {
        return requireTimes;
    }

    public void setRequireTimes(int requireTimes) {
        this.requireTimes = requireTimes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
