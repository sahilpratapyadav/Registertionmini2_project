package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.repository.UserAccountMasterRepo;

@SpringBootApplication
public class MiniProject2Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context= SpringApplication.run(MiniProject2Application.class, args);
		 //UserAccountMasterRepo bean = context.getBean(UserAccountMasterRepo.class);
		 //bean.save(user);
		
	}

}
