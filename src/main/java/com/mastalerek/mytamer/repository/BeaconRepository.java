package com.mastalerek.mytamer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastalerek.mytamer.entity.Beacon;

public interface BeaconRepository extends CrudRepository<Beacon, Integer> {

	List<Beacon> findByUuidAndMinorAndMajor(String uuid, Integer major, Integer minor);

}
