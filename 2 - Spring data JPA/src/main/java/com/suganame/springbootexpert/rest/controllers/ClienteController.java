package com.suganame.springbootexpert.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.repositories.Clientes;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private Clientes clientes;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Cliente> save(@RequestBody Cliente data) {
        Cliente cliente = clientes.save(data);
        return ResponseEntity.ok(cliente);
    }

}
