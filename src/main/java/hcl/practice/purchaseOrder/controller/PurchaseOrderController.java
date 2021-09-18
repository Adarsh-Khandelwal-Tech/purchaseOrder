package hcl.practice.purchaseOrder.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcl.practice.purchaseOrder.entity.MyInventory;
import hcl.practice.purchaseOrder.model.MyInventoryDTO;
import hcl.practice.purchaseOrder.model.MyInventoryUpdateDTO;
import hcl.practice.purchaseOrder.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@PostMapping(value="/inv")
	public MyInventory postInv(@RequestBody MyInventoryDTO dto) {
		
		return purchaseOrderService.postMyInventory(dto);
	}
	
	@PutMapping(value="/inv")
	public MyInventory putInv(@RequestBody MyInventoryUpdateDTO dto,@RequestHeader(required=true) String myHeader) {
		System.out.println("My Header value is PUT "+myHeader);
		return purchaseOrderService.putMyInventory(dto);
	}
	
	@GetMapping(value="/inv/{productName}")
	public Map<String,Object> postInv(@PathVariable("productName") String productName,@RequestHeader(required=true) String myHeader) {		
		System.out.println("My Header value is GET "+myHeader);
		return purchaseOrderService.getMyInventory(productName);
	}
	
}
