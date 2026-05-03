package com.gimnasio.gimnasio_api.repository;

import com.gimnasio.gimnasio_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}