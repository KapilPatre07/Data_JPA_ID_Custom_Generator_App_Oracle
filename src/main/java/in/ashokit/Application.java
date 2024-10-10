package in.ashokit;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.OrderDetailsEntity;
import in.ashokit.repo.OrderDetailsRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		OrderDetailsRepository bean = context.getBean(OrderDetailsRepository.class);
		
		OrderDetailsEntity entity = new OrderDetailsEntity();
		
		entity.setOrderBy("Reshma");
		entity.setOrderPlacedDate(new Date());
		
		OrderDetailsEntity saveEntity = bean.save(entity);
		
		System.out.println(saveEntity);
		
		context.close();
	}

}
