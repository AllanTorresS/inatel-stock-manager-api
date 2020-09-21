package br.com.grupo.inatel.model.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "stock")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stock {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String description;

}
