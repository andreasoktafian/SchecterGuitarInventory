package com.andreas.SchecterGuitarInventory.controllers;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductDto;
import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductInsertDto;
import com.andreas.SchecterGuitarInventory.exception.RestResponse;
import com.andreas.SchecterGuitarInventory.services.CategoryServiceImplementation;
import com.andreas.SchecterGuitarInventory.services.RejectedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reject")
public class RejectedProductController {

    @Autowired
    private RejectedProductService rejectedProductService;

    @GetMapping
    public ResponseEntity<RestResponse<List<RejectedProductDto>>> findAllReject(){
        return new ResponseEntity<>(
                new RestResponse<>(rejectedProductService.findAllRejectedProduct(),
                        rejectedProductService.findAllRejectedProduct().size() + " Rejected Product Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestResponse<Boolean>> insertNewReject(@RequestBody RejectedProductInsertDto newReject){
        return new ResponseEntity<>(
                new RestResponse<>(rejectedProductService.insertRejectedProduct(newReject),
                        "Berhasil Menambahkan Reject Product.",
                        "201"),
                HttpStatus.CREATED);
    }

}
