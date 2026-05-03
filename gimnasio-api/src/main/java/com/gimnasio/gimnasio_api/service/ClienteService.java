package com.gimnasio.gimnasio_api.service;

import com.gimnasio.gimnasio_api.entity.Cliente;
import com.gimnasio.gimnasio_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente datos) {
        Cliente cliente = buscarPorId(id);
        cliente.setNombre(datos.getNombre());
        cliente.setApellido(datos.getApellido());
        cliente.setTelefono(datos.getTelefono());
        cliente.setEmail(datos.getEmail());
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}