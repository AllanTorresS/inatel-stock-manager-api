package br.com.grupo.inatel.controller;

import br.com.grupo.inatel.model.entitys.History;
import br.com.grupo.inatel.service.QuotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/quotes-history")
@Api(value = "API REST Quotes")
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @PostMapping("/save")
    @ApiOperation(value = "Salva uma cotação")
    public ResponseEntity save(@Valid @RequestBody History quotesHistory) {
        return ResponseEntity.status(HttpStatus.OK).body(this.quotesService.save(quotesHistory));
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Busca uma cotação pelo seu id")
    public ResponseEntity findById(@Valid @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.quotesService.findById(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "Lista todas as cotações")
    public ResponseEntity listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.quotesService.findAll());
    }

}
