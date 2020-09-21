package br.com.grupo.inatel.controller;

import br.com.grupo.inatel.model.entitys.Stock;
import br.com.grupo.inatel.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/stock-manager")
@Api(value = "API REST Stoks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/save")
    @ApiOperation(value = "Salva um chave cotação")
    public ResponseEntity save(@Valid @RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.OK).body(this.stockService.save(stock));
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Busca uma chave de cotação pelo seu id")
    public ResponseEntity findById(@Valid @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.stockService.findById(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "Lista todas as chaves cotações")
    public ResponseEntity listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.stockService.findAll());
    }

}
