package hcl.practice.purchaseOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcl.practice.purchaseOrder.entity.MyInventory;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<MyInventory, Integer>{

	MyInventory findByProductName(String productName);
}
