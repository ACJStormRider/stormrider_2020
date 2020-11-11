package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
}
