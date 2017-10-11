package pnodder.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pnodder.repositories.ResidentRepository;

@Configuration
public class TestConfig  {

    @Bean
    public ResidentRepository residentRepositoryMock() {
        return Mockito.mock(ResidentRepository.class);
    }

}
