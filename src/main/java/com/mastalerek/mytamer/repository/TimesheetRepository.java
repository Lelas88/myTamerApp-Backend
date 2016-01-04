package com.mastalerek.mytamer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {

	public List<Timesheet> findByStudentIdAndDateBetween(Integer studentId, Date dateFrom, Date dateTo);

}
