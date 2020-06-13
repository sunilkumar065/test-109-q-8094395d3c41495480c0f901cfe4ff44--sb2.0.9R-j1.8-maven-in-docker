package org.codejudge.sb.repository;

import java.util.Optional;

import org.codejudge.sb.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long>{

	Optional<Driver> findByMobile(Long mobile);
	Optional<Driver> findByCarNo(String carNo);
	Optional<Driver> findByLicenseNo(String licenseNo);
	Optional<Driver> findByEmail(String email);
}
