package com.gimnasio.gimnasio_api;

import com.gimnasio.gimnasio_api.entity.Cliente;
import com.gimnasio.gimnasio_api.repository.ClienteRepository;
import com.gimnasio.gimnasio_api.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void listarTodos_retornaLista() {
        Cliente c = new Cliente();
        c.setNombre("Juan");
        when(clienteRepository.findAll()).thenReturn(List.of(c));

        List<Cliente> resultado = clienteService.listarTodos();

        assertFalse(resultado.isEmpty());
        assertEquals("Juan", resultado.get(0).getNombre());
    }

    @Test
    void buscarPorId_retornaCliente() {
        Cliente c = new Cliente();
        c.setId(1L);
        c.setNombre("Juan");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(c));

        Cliente resultado = clienteService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void buscarPorId_noExiste_lanzaExcepcion() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> clienteService.buscarPorId(99L));
    }

    @Test
    void crear_guardaCliente() {
        Cliente c = new Cliente();
        c.setNombre("Juan");
        when(clienteRepository.save(any(Cliente.class))).thenReturn(c);

        Cliente resultado = clienteService.crear(c);

        assertNotNull(resultado);
        verify(clienteRepository, times(1)).save(c);
    }

    @Test
    void eliminar_llamaDeleteById() {
        clienteService.eliminar(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}