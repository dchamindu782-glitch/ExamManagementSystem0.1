package schoolInformationsystem.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @Column(name = "exam_id", nullable = false, unique = true, length = 50)
    private String examId;

    @Column(name = "exam_name", nullable = false, length = 150)
    private String examName;

    @Column(name = "term", nullable = false)
    private String term;

    @Column(name = "academic_year")
    private Integer academicYear = 2026;

    @Column(name = "status", length = 20)
    private String status = "DRAFT";

    public Exam() {
    }

    public Exam(String examId, String examName, String term) {
        this.examId = examId;
        this.examName = examName;
        this.term = term;
        this.academicYear = 2026;
        this.status = "DRAFT";
    }

    public Exam(String examId, String examName, String term, Integer academicYear, String status) {
        this.examId = examId;
        this.examName = examName;
        this.term = term;
        this.academicYear = academicYear != null ? academicYear : 2026;
        this.status = status != null ? status : "DRAFT";
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}