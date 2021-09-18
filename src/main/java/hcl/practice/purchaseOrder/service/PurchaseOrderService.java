package hcl.practice.purchaseOrder.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcl.practice.purchaseOrder.entity.MyInventory;
import hcl.practice.purchaseOrder.model.MyInventoryDTO;
import hcl.practice.purchaseOrder.model.MyInventoryUpdateDTO;
import hcl.practice.purchaseOrder.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	public MyInventory postMyInventory(MyInventoryDTO dto) {
		
		MyInventory inv=new MyInventory();
		inv.setProductName(dto.getProductName());
		inv.setTotalUnits(dto.getTotalUnits());
		
		return purchaseOrderRepository.save(inv);
	}
	
	public MyInventory putMyInventory(MyInventoryUpdateDTO dto) {
		MyInventory inv=purchaseOrderRepository.findByProductName(dto.getProductName());
		
		if(dto.getOperation().equals("add")) {
			inv.setTotalUnits(inv.getTotalUnits()+dto.getTotalUnits());
		}
		else {
			inv.setTotalUnits(inv.getTotalUnits()-dto.getTotalUnits());
		}
		return purchaseOrderRepository.save(inv);
	}
	
	public Map<String,Object> getMyInventory(String productName) {
		MyInventory inv=purchaseOrderRepository.findByProductName(productName);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(inv, Map.class);
		return map;
	}
}
