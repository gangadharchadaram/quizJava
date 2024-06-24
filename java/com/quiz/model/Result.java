package com.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long Id;
  @NotBlank
  private String subject;
  @NotBlank
  private long Score;

  @OneToOne
  @JoinColumn(name = "EmpId")
  private Employee employee;
}