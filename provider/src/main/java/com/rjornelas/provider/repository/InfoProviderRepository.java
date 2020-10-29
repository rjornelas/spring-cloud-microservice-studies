package com.rjornelas.provider.repository;

import com.rjornelas.provider.model.InfoProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoProviderRepository extends JpaRepository<InfoProvider, Long> {

    InfoProvider findByState(String state);
}
