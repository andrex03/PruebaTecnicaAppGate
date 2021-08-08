package co.com.andresvasquez.prueba.config;

import co.com.andresvasquez.prueba.beanprocessor.CalculateOperation;
import co.com.andresvasquez.prueba.beanprocessor.SaveToList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculationServiceConfig {

    @Bean
    public CalculateOperation createCalculationOperation(){
        return new CalculateOperation();
    }
    @Bean
    public SaveToList createSaveToList(){
    return new SaveToList();
    }
}
