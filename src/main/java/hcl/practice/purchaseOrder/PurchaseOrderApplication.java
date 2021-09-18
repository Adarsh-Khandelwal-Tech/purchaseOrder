package hcl.practice.purchaseOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "hcl.practice.purchaseOrder.repository")
@ComponentScan(basePackages = { "hcl.practice.purchaseOrder" })
public class PurchaseOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderApplication.class, args);
	}

}
