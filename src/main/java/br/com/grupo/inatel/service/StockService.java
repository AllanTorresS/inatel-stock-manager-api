package br.com.grupo.inatel.service;

import br.com.grupo.inatel.dao.StockRepository;
import br.com.grupo.inatel.model.entitys.Stock;
import br.com.grupo.inatel.model.error.AcertNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public Stock save(Stock stock) {
        return this.stockRepository.save(stock);
    }

    public Stock findById(String id) {
        return this.stockRepository.findById(id).orElseThrow(()-> new AcertNotFoundExeception("not.found.execption"));
    }

    public List<Stock> findAll() {
        return this.stockRepository.findAll();
    }
}
