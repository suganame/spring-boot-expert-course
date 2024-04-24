package com.suganame.springbootexpert.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suganame.springbootexpert.domain.entities.Cliente;
import com.suganame.springbootexpert.domain.entities.ItemPedido;
import com.suganame.springbootexpert.domain.entities.Pedido;
import com.suganame.springbootexpert.domain.entities.Produto;
import com.suganame.springbootexpert.domain.enums.StatusPedido;
import com.suganame.springbootexpert.domain.repositories.Clientes;
import com.suganame.springbootexpert.domain.repositories.ItensPedido;
import com.suganame.springbootexpert.domain.repositories.Pedidos;
import com.suganame.springbootexpert.domain.repositories.Produtos;
import com.suganame.springbootexpert.exception.PedidoNaoEncontradoException;
import com.suganame.springbootexpert.exception.RegraNegocioException;
import com.suganame.springbootexpert.rest.dtos.ItemPedidoDTO;
import com.suganame.springbootexpert.rest.dtos.PedidoDTO;
import com.suganame.springbootexpert.service.PedidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private final Pedidos repository;

    @Autowired
    private final Clientes clientesRepository;

    @Autowired
    private final Produtos produtosRepository;

    @Autowired
    private final ItensPedido itensPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código do cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itensPedido = this.serializeItems(pedido, dto.getItems());

        repository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    private List<ItemPedido> serializeItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items
                .stream()
                .map(item -> {

                    Integer idProduto = item.getProduto();
                    Produto produto = produtosRepository.findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Código do produto inválido."));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(item.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void atualizaStatus(Integer id, StatusPedido statusPedido) {
        repository
            .findById(id)
            .map(pedido -> {
                pedido.setStatus(statusPedido);
                return repository.save(pedido);
            })
            .orElseThrow(() -> new PedidoNaoEncontradoException(null));
    }
}
