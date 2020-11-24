package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
